package br.com.infnet.paymentapp.dao;

import br.com.infnet.paymentapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
