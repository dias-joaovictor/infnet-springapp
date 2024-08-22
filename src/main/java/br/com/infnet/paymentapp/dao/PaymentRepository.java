package br.com.infnet.paymentapp.dao;

import br.com.infnet.paymentapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query("from Payment p where p.order.id = :orderId")
    List<Payment> findByOrderId(@Param("orderId") UUID orderId);
}
