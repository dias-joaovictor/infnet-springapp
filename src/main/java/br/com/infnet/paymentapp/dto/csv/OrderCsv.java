package br.com.infnet.paymentapp.dto.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCsv implements Csv {

    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvBindByName(column = "Order Date")
    private LocalDate orderDate;

    @CsvBindByName(column = "Amount")
    private BigDecimal amount;

    @CsvBindByName(column = "Total Amount")
    private BigDecimal totalAmount;

    @CsvBindByName(column = "Customer ID")
    private UUID customerId;

    @CsvBindByName(column = "Customer Full Name")
    private String customerFullName;

    @CsvBindByName(column = "Customer Date of Birth")
    private LocalDate customerDateOfBirth;

    @CsvBindByName(column = "Customer Enabled")
    private boolean customerEnabled;
}

