package br.com.infnet.paymentapp.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "paymentId")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PixPayment extends Payment {
    private String pixKey;
}

