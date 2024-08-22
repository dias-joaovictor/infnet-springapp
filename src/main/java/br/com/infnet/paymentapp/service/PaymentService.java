package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;

public interface PaymentService extends CsvConvertedEntityPersisterService<Payment> {
}
