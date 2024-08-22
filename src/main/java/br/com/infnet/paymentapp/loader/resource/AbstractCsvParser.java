package br.com.infnet.paymentapp.loader.resource;

import br.com.infnet.paymentapp.dto.csv.Csv;
import br.com.infnet.paymentapp.service.csv.CsvParserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractCsvParser<C extends Csv> implements CsvParser<C> {

    private final CsvParserService csvParserService;

    @Override
    public List<C> parseCsv() {
        return Optional.ofNullable(getResource())
                .map(resource -> csvParserService.parse(resource, getGenericClass()))
                .orElse(List.of());
    }

    protected abstract Resource getResource();

    @SuppressWarnings("unchecked")
    private Class<C> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<C>) parameterizedType.getActualTypeArguments()[0];
    }
}
