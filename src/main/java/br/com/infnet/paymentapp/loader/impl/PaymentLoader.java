package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.loader.LoaderLink;
import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentLoader implements LoaderLink<Payment> {

    private final LoaderLink<Order> nextLoaderLink;

    @Override
    public void load() {

    }

    @Override
    public void loadNext() {
        nextLoaderLink.loadNext();
    }
}
