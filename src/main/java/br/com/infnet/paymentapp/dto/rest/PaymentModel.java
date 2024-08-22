package br.com.infnet.paymentapp.dto.rest;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CardPaymentModel.class, name = "CARD"),
        @JsonSubTypes.Type(value = PixPaymentModel.class, name = "PIX"),
})
public abstract class PaymentModel implements RequestModel, ResponseModel {

    private UUID id;

    private BigDecimal amount;

    private UUID orderId;
}

