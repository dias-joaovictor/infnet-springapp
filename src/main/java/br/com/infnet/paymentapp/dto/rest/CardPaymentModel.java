package br.com.infnet.paymentapp.dto.rest;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CardPaymentModel extends PaymentModel {
    private String cardHash;
    private String cardholderName;
    private LocalDate expiryDate;
}

