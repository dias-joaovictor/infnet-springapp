package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;

import java.util.UUID;

public interface OrderService extends CsvConvertedEntityPersisterService<Order> {
    Order getOrderById(UUID id);
}
