package br.com.infnet.paymentapp.dto.rest;


import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PixPaymentModel extends PaymentModel {
    private String pixKey;
}

