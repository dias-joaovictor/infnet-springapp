package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.csv.OrderCsv;
import br.com.infnet.paymentapp.dto.rest.OrderModel;
import br.com.infnet.paymentapp.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderConverter extends CsvConverter<OrderCsv, Order>,
        InboundConverter<OrderModel, Order>,
        OutboundConverter<Order, OrderModel> {
}
