package br.com.infnet.paymentapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "paymentId")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CardPayment extends Payment {
    private String cardHash;
    private String cardholderName;
    private LocalDate expiryDate;
}

