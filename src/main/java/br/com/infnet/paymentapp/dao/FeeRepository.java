package br.com.infnet.paymentapp.dao;

import br.com.infnet.paymentapp.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeeRepository extends JpaRepository<Fee, UUID> {
}
