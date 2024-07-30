package br.com.infnet.paymentapp.dao;

import br.com.infnet.paymentapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
