package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl extends BasicCrudOperationServiceImpl<Payment, UUID> implements PaymentService {

    public PaymentServiceImpl(JpaRepository<Payment, UUID> repository) {
        super(repository);
    }

    @Override
    public void save(Payment entity) {
        repository.save(entity);
    }
}
