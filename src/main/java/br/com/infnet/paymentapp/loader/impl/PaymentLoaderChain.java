package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.converter.CsvConverter;
import br.com.infnet.paymentapp.dto.csv.PaymentCsv;
import br.com.infnet.paymentapp.loader.LoaderChain;
import br.com.infnet.paymentapp.loader.NoneChainLink;
import br.com.infnet.paymentapp.loader.resource.CsvParser;
import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.service.OrderService;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PaymentLoaderChain extends BaseLoaderChain<PaymentCsv, PaymentCsv, Payment> {

    private final OrderService orderService;

    public PaymentLoaderChain(
            @Nullable LoaderChain<NoneChainLink> nextLoaderLink,
            CsvParser<PaymentCsv> parser,
            CsvConverter<PaymentCsv, Payment> converter,
            CsvConvertedEntityPersisterService<Payment> service,
            OrderService orderService) {
        super(nextLoaderLink, parser, converter, service);
        this.orderService = orderService;
    }

    @Override
    protected void preSave(List<Payment> data) {
        data.forEach(payment -> {
            var order = orderService.getOrderById(payment.getOrderId());
            payment.setOrder(order);
        });
    }
}
