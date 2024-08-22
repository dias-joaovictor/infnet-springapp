package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Customer;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;

import java.util.UUID;

public interface CustomerService extends CsvConvertedEntityPersisterService<Customer> {
    Customer findById(UUID id);
}
