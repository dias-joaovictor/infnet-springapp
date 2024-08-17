package br.com.infnet.paymentapp.dto.csv;

import br.com.infnet.paymentapp.loader.ChainLink;
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
public class CustomerCsv implements Csv, ChainLink {

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
