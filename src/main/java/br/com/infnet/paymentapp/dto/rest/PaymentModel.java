package br.com.infnet.paymentapp.dto.rest;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PaymentModel implements RequestModel, ResponseModel {

    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvBindByName(column = "Order ID")
    private UUID orderId;

    @CsvBindByName(column = "Type")
    private Type type;

    @CsvBindByName(column = "PIX Key")
    private String pixKey;

    @CsvBindByName(column = "Amount")
    private BigDecimal amount;

    @CsvBindByName(column = "Card Hash")
    private String cardHash;

    @CsvBindByName(column = "Cardholder Name")
    private String cardholderName;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "Expiry Date")
    private LocalDate expiryDate;

    public enum Type {
        CARD, PIX
    }
}

