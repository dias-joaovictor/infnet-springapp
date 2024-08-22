package br.com.infnet.paymentapp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "paymentId")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("CARD")
public class CardPayment extends Payment {
    private String cardHash;
    private String cardholderName;
    private LocalDate expiryDate;
}

