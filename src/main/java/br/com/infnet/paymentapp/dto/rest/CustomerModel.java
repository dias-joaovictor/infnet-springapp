package br.com.infnet.paymentapp.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerModel implements RequestModel, ResponseModel {

    private UUID id;

    private String fullName;

    private LocalDate dateOfBirth;

    private boolean enabled;
}
