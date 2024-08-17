package br.com.infnet.paymentapp.service.csv;

import br.com.infnet.paymentapp.dto.csv.Csv;
import org.springframework.core.io.Resource;

import java.util.List;

public interface CsvLoaderService {

    <T extends Csv> List<T> load(Resource file, Class<T> clazz);

}
