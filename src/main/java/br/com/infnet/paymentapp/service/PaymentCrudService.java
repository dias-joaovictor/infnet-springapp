package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class PaymentCrudService extends BasicCrudOperationServiceImpl<Payment, UUID> implements PaymentService {

    public PaymentCrudService(JpaRepository<Payment, UUID> repository) {
        super(repository);
    }

    public abstract List<Payment> findByOrderId(UUID orderId);
}
