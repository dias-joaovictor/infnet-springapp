package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.csv.CustomerCsv;
import br.com.infnet.paymentapp.dto.rest.CustomerModel;
import br.com.infnet.paymentapp.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerConverter extends CsvConverter<CustomerCsv, Customer>,
        InboundConverter<CustomerModel, Customer>,
        OutboundConverter<Customer, CustomerModel> {
}
