package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.converter.CsvConverter;
import br.com.infnet.paymentapp.dto.csv.Csv;
import br.com.infnet.paymentapp.loader.ChainLink;
import br.com.infnet.paymentapp.loader.LoaderChain;
import br.com.infnet.paymentapp.loader.resource.CsvParser;
import br.com.infnet.paymentapp.model.ModelEntity;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import java.util.List;

@Slf4j
public abstract class BaseLoaderChain<
        C extends ChainLink,
        CSV extends Csv,
        E extends ModelEntity> extends LoaderChain<C> {

    private final CsvParser<CSV> parser;
    private final CsvConverter<CSV, E> converter;
    private final CsvConvertedEntityPersisterService<E> service;

    public BaseLoaderChain(
            @Nullable LoaderChain<?> nextLoaderLink,
            CsvParser<CSV> parser,
            CsvConverter<CSV, E> converter,
            CsvConvertedEntityPersisterService<E> service) {
        super(nextLoaderLink);
        this.parser = parser;
        this.converter = converter;
        this.service = service;
    }

    @Override
    protected void handle() {
        var data = parser.parseCsv()
                .stream()
                .map(converter::convert)
                .toList();
        preSave(data);
        save(data);
        log.info(data.toString());
    }

    protected void preSave(List<E> data) {
        // do nothing
    }

    protected void save(List<E> data) {
        data.forEach(service::save);
    }
}
