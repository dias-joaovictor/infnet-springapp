package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.exception.InvalidEntityException;
import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl extends BasicCrudOperationServiceImpl<Payment, UUID> implements PaymentService {

    private final OrderService orderService;

    public PaymentServiceImpl(JpaRepository<Payment, UUID> repository, OrderService orderService) {
        super(repository);
        this.orderService = orderService;
    }

    @Override
    public void save(Payment entity) {
        repository.save(entity);
    }

    @Override
    public Payment crudSave(Payment entity) {
        includeOrder(entity);
        return super.crudSave(entity);
    }

    private void includeOrder(Payment entity) {
        if (entity.getOrderId() == null) {
            throw new InvalidEntityException(Payment.class, "Order ID not present");
        }
        entity.setOrder(orderService.getOrderById(entity.getOrderId()));
    }
}
