package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.converter.CsvConverter;
import br.com.infnet.paymentapp.dto.csv.CustomerCsv;
import br.com.infnet.paymentapp.dto.csv.OrderCsv;
import br.com.infnet.paymentapp.loader.LoaderChain;
import br.com.infnet.paymentapp.loader.resource.CsvParser;
import br.com.infnet.paymentapp.model.Customer;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerLoaderChain extends BaseLoaderChain<CustomerCsv, CustomerCsv, Customer> {

    public CustomerLoaderChain(
            @Nullable LoaderChain<OrderCsv> nextLoaderLink,
            CsvParser<CustomerCsv> parser,
            CsvConverter<CustomerCsv, Customer> converter,
            CsvConvertedEntityPersisterService<Customer> service) {
        super(nextLoaderLink, parser, converter, service);
    }
}
