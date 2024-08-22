package br.com.infnet.paymentapp.service.csv;

import br.com.infnet.paymentapp.dto.csv.Csv;
import org.springframework.core.io.Resource;

import java.util.List;

public interface CsvParserService<T extends Csv> {

    List<T> parse(Resource file, Class<T> clazz);

}
