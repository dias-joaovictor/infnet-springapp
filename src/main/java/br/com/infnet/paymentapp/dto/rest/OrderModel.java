package br.com.infnet.paymentapp.dto.rest;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
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
public class OrderModel implements RequestModel, ResponseModel {

    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "Order Date")
    private LocalDate orderDate;

    @CsvBindByName(column = "Amount")
    private BigDecimal amount;

    @CsvBindByName(column = "Total Amount")
    private BigDecimal totalAmount;

    @CsvBindByName(column = "Customer ID")
    private UUID customerId;
}

