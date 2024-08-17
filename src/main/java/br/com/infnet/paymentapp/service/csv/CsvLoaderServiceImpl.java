package br.com.infnet.paymentapp.service.csv;

import br.com.infnet.paymentapp.dto.csv.Csv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class CsvLoaderServiceImpl implements CsvLoaderService {

    @Override
    public <T extends Csv> List<T> load(Resource resource, Class<T> clazz) {
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .build();
            return cb.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
