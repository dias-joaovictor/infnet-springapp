package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.PaymentRepository;
import br.com.infnet.paymentapp.exception.InvalidEntityException;
import br.com.infnet.paymentapp.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl extends PaymentCrudService implements PaymentService {

    private final OrderService orderService;

    public PaymentServiceImpl(PaymentRepository repository, OrderService orderService) {
        super(repository);
        this.orderService = orderService;
    }

    @Override
    public void save(Payment entity) {
        repository.save(entity);
    }
    
    @Override
    protected void doBeforeSaveOnSave(Payment entity) {
        super.doBeforeSaveOnSave(entity);
        includeOrder(entity);
    }

    @Override
    protected void doBeforeSaveOnUpdate(Payment entity) {
        super.doBeforeSaveOnUpdate(entity);
        includeOrder(entity);
    }

    private void includeOrder(Payment entity) {
        if (entity.getOrderId() == null) {
            throw new InvalidEntityException(Payment.class, "Order ID not present");
        }
        entity.setOrder(orderService.getOrderById(entity.getOrderId()));
    }

    @Override
    public List<Payment> findByOrderId(UUID orderId) {
        return ((PaymentRepository) repository).findByOrderId(orderId);
    }
}
