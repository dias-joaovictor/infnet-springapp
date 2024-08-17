package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.OrderRepository;
import br.com.infnet.paymentapp.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public void save(Order entity) {
        repository.save(entity);
    }

    @Override
    public Order getOrderById(UUID id) {
        return repository.getReferenceById(id);
    }
}
