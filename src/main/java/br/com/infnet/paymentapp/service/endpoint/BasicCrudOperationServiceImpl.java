package br.com.infnet.paymentapp.service.endpoint;

import br.com.infnet.paymentapp.exception.EntityAlreadyExistsException;
import br.com.infnet.paymentapp.exception.EntityNotFoundException;
import br.com.infnet.paymentapp.exception.InvalidEntityException;
import br.com.infnet.paymentapp.exception.NullEntityException;
import br.com.infnet.paymentapp.model.ModelEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@RequiredArgsConstructor
public abstract class BasicCrudOperationServiceImpl<E extends ModelEntity, ID extends Serializable> implements CrudOperationService<E, ID> {

    protected final JpaRepository<E, ID> repository;

    @Override
    public E crudSave(E entity) {
        if (entity == null) {
            throw new NullEntityException(getGenericClass());
        }
        if (entity.getId() != null && repository.existsById((ID) entity.getId())) {
            throw new EntityAlreadyExistsException(getGenericClass(), entity.getId());
        }
        return repository.save(entity);
    }

    @Override
    public E crudUpdate(ID id, E entity) {
        if (entity == null || id == null) {
            throw new NullEntityException(getGenericClass());
        }

        if (entity.getId() == null) {
            throw new InvalidEntityException(getGenericClass(), "Invalid ID");
        }

        crudFindById(id);
        
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public List<E> crudFindAll() {
        return repository.findAll();
    }

    @Override
    public E crudFindById(ID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(getGenericClass(), id));
    }

    @Override
    public void crudDeleteById(ID id) {
        E entity = crudFindById(id);
        repository.delete(entity);
    }

    protected JpaRepository<E, ID> getRepository() {
        return repository;
    }

    @SuppressWarnings("unchecked")
    private Class<E> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) parameterizedType.getActualTypeArguments()[0];
    }
}
