package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.PaymentRepository;
import br.com.infnet.paymentapp.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    @Override
    public void save(Payment entity) {
        repository.save(entity);
    }
}
