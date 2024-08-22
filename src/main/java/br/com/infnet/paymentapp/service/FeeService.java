package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.model.Fee;
import br.com.infnet.paymentapp.service.csv.CsvConvertedEntityPersisterService;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FeeService extends CsvConvertedEntityPersisterService<Fee> {
    BigDecimal getFeeForDate(LocalDate date);
}
