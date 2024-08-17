package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.converter.CsvConverter;
import br.com.infnet.paymentapp.dto.csv.CustomerCsv;
import br.com.infnet.paymentapp.dto.csv.FeeCsv;
import br.com.infnet.paymentapp.loader.ChainStarter;
import br.com.infnet.paymentapp.loader.LoaderChain;
import br.com.infnet.paymentapp.loader.resource.CsvParser;
import br.com.infnet.paymentapp.model.Fee;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeeLoaderChain extends BaseLoaderChain<FeeCsv, FeeCsv, Fee> implements ChainStarter {

    public FeeLoaderChain(LoaderChain<CustomerCsv> nextLoaderLink,
                          CsvParser<FeeCsv> parser,
                          CsvConverter<FeeCsv, Fee> converter,
                          CsvConvertedEntityPersisterService<Fee> service) {
        super(nextLoaderLink, parser, converter, service);
    }

    @Override
    public void startChain() {
        load();
    }
}
