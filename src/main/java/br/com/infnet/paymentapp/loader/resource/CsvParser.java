package br.com.infnet.paymentapp.loader.resource;

import br.com.infnet.paymentapp.dto.csv.Csv;

import java.util.List;

public interface CsvParser<C extends Csv> {

    List<C> parseCsv();

}
