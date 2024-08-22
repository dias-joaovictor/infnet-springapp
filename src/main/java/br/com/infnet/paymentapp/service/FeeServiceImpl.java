package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.FeeRepository;
import br.com.infnet.paymentapp.model.Fee;
import br.com.infnet.paymentapp.service.endpoint.BasicCrudOperationServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class FeeServiceImpl extends BasicCrudOperationServiceImpl<Fee, UUID> implements FeeService {
    
    public FeeServiceImpl(FeeRepository feeRepository) {
        super(feeRepository);
    }

    @Override
    public void save(Fee entity) {
        repository.save(entity);
    }

    @Override
    public BigDecimal getFeeForDate(LocalDate date) {
        return ((FeeRepository) repository).findFeeForDate(date)
                .map(Fee::getFeeAmount)
                .orElse(BigDecimal.ZERO);
    }
}
