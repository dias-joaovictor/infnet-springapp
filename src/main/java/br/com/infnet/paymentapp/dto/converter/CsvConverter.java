package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.csv.Csv;
import br.com.infnet.paymentapp.model.ModelEntity;

public interface CsvConverter<S extends Csv, T extends ModelEntity> {
    T convert(S source);
}
