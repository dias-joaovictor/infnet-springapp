package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.converter.CsvConverter;
import br.com.infnet.paymentapp.dto.csv.OrderCsv;
import br.com.infnet.paymentapp.dto.csv.PaymentCsv;
import br.com.infnet.paymentapp.loader.LoaderChain;
import br.com.infnet.paymentapp.loader.resource.CsvParser;
import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.service.CustomerService;
import br.com.infnet.paymentapp.service.FeeService;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderLoaderChain extends BaseLoaderChain<OrderCsv, OrderCsv, Order> {

    private final FeeService feeService;
    private final CustomerService customerService;

    public OrderLoaderChain(
            @Nullable LoaderChain<PaymentCsv> nextLoaderLink,
            CsvParser<OrderCsv> parser,
            CsvConverter<OrderCsv, Order> converter,
            CsvConvertedEntityPersisterService<Order> service, FeeService feeService, CustomerService customerService) {
        super(nextLoaderLink, parser, converter, service);
        this.feeService = feeService;
        this.customerService = customerService;
    }

    @Override
    protected void preSave(List<Order> data) {
        data.forEach(order -> {
            order.setFee(feeService.getFeeForDate(order.getOrderDate()));
            order.setCustomer(customerService.findById(order.getCustomerId()));
        });
    }
}
