package br.com.infnet.paymentapp.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel implements RequestModel, ResponseModel {

    private UUID id;

    private LocalDate orderDate;

    private BigDecimal amount;

    private BigDecimal totalAmount;

    private BigDecimal fee;

    private CustomerModel customer;

    private BigDecimal totalPaid;

    private BigDecimal remainingAmount;

    private List<PaymentModel> payments = new ArrayList<>();
}

