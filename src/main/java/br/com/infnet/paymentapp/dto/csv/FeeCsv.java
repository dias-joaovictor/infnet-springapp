package br.com.infnet.paymentapp.dto.csv;

import br.com.infnet.paymentapp.loader.ChainLink;
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
public class FeeCsv implements Csv, ChainLink {

    @CsvBindByName(column = "ID")
    private UUID id;

    @CsvBindByName(column = "Fee Amount")
    private BigDecimal feeAmount;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "From Date")
    private LocalDate fromDate;
}

