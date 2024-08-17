package br.com.infnet.paymentapp.dto.csv;


import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PixPaymentCsv extends PaymentCsv {

    @CsvBindByName(column = "PIX Key")
    private String pixKey;
}
