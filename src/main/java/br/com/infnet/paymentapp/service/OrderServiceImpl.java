package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class OrderServiceImpl extends BasicCrudOperationServiceImpl<Order, UUID> implements OrderService {

    private final FeeService feeService;

    public OrderServiceImpl(JpaRepository<Order, UUID> repository, FeeService feeService) {
        super(repository);
        this.feeService = feeService;
    }

    @Override
    public void save(Order entity) {
        repository.save(entity);
    }

    @Override
    public Order getOrderById(UUID id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Order crudSave(Order entity) {
        updateFee(entity);
        return super.crudSave(entity);
    }

    @Override
    public Order crudUpdate(UUID uuid, Order entity) {
        updateFee(entity);
        return super.crudUpdate(uuid, entity);
    }

    private void updateFee(Order entity) {
        if (entity.getId() == null) {
            entity.setOrderDate(LocalDate.now());
        }
        entity.setFee(feeService.getFeeForDate(entity.getOrderDate()));
    }
}
