package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.CustomerRepository;
import br.com.infnet.paymentapp.model.Customer;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl extends BasicCrudOperationServiceImpl<Customer, UUID> implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public void save(Customer entity) {
        repository.save(entity);
    }

    @Override
    public Customer findById(UUID id) {
        return repository.getReferenceById(id);
    }
}
