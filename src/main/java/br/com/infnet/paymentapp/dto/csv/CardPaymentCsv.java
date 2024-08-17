package br.com.infnet.paymentapp.dto.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CardPaymentCsv extends PaymentCsv {
    
    @CsvBindByName(column = "Card Hash")
    private String cardHash;

    @CsvBindByName(column = "Cardholder Name")
    private String cardholderName;

    @CsvBindByName(column = "Expiry Date")
    private LocalDate expiryDate;
}

