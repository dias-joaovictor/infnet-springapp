package br.com.infnet.paymentapp.dto.csv;

import com.opencsv.bean.CsvBindByName;
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
public abstract class PaymentCsv implements Csv {

    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvBindByName(column = "Order ID")
    private UUID order;

    @CsvBindByName(column = "Amount")
    private BigDecimal amount;
}

