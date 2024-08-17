package br.com.infnet.paymentapp.dao;

import br.com.infnet.paymentapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
