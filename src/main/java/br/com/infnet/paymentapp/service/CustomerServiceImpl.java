package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.CustomerRepository;
import br.com.infnet.paymentapp.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public void save(Customer entity) {
        repository.save(entity);
    }

    @Override
    public Customer findById(UUID id) {
        return repository.getReferenceById(id);
    }
}
