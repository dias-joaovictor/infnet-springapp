package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.loader.LoaderLink;
import br.com.infnet.paymentapp.model.Customer;
import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLoader implements LoaderLink<Order> {


    @Override
    public void load() {

    }
}
