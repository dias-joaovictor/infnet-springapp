package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.csv.CustomerCsv;
import br.com.infnet.paymentapp.dto.csv.PaymentCsv;
import br.com.infnet.paymentapp.loader.LoaderLink;
import br.com.infnet.paymentapp.service.csv.CsvLoaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerLoader extends LoaderLink<CustomerCsv> {

    private final LoaderLink<PaymentCsv> nextLoaderLink;

    private final CsvLoaderService csvLoaderService;

    @Value("classpath:loaders/customers.csv")
    private Resource resource;

    @Override
    public void doLoad() {
        var csv = csvLoaderService.load(resource, CustomerCsv.class);
        nextLoaderLink.load();
    }

    @Override
    protected LoaderLink<PaymentCsv> getNextLink() {
        return nextLoaderLink;
    }
}
