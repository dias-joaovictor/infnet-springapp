package br.com.infnet.paymentapp.service.endpoint;

import br.com.infnet.paymentapp.model.ModelEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudOperationService<E extends ModelEntity, ID extends Serializable> {
    E crudSave(E entity);

    E crudUpdate(ID id, E entity);

    void crudDeleteById(ID id);

    List<E> crudFindAll();

    E crudFindById(ID id);
}
