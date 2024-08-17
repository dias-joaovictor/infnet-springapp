package br.com.infnet.paymentapp.dto.rest;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
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

    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvBindByName(column = "Full Name")
    private String fullName;

    @CsvBindByName(column = "Date of Birth")
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @CsvBindByName(column = "Enabled")
    private boolean enabled;
}
