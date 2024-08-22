package br.com.infnet.paymentapp.dto.rest;

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
public class FeeModel implements RequestModel, ResponseModel {

    private UUID id;

    private BigDecimal feeAmount;

    private LocalDate fromDate;
}

