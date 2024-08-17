package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl extends BasicCrudOperationServiceImpl<Order, UUID> implements OrderService {

    public OrderServiceImpl(JpaRepository<Order, UUID> repository) {
        super(repository);
    }

    @Override
    public void save(Order entity) {
        repository.save(entity);
    }

    @Override
    public Order getOrderById(UUID id) {
        return repository.getReferenceById(id);
    }
}
