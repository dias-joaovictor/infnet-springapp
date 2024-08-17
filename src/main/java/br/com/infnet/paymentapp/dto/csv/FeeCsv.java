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
public class FeeCsv implements Csv {
    
    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvBindByName(column = "Fee Amount")
    private BigDecimal feeAmount;

    @CsvBindByName(column = "From Date")
    private LocalDate fromDate;
}

