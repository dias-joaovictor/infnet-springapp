package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.csv.CustomerCsv;
import br.com.infnet.paymentapp.dto.csv.FeeCsv;
import br.com.infnet.paymentapp.loader.LoaderChainStarter;
import br.com.infnet.paymentapp.loader.LoaderLink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeeLoader implements LoaderChainStarter, LoaderLink<FeeCsv> {

    private final LoaderLink<CustomerCsv> nextLoaderLink;


    @Override
    public void load() {

    }

    @Override
    public void loadNext() {
        nextLoaderLink.loadNext();
    }

    @Override
    public void startLoaderChain() {
        load();
    }
}
