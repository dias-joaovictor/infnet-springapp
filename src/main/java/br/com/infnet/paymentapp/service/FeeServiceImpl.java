package br.com.infnet.paymentapp.service;

import br.com.infnet.paymentapp.dao.FeeRepository;
import br.com.infnet.paymentapp.model.Fee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {

    private final FeeRepository repository;

    @Override
    public void save(Fee entity) {
        repository.save(entity);
    }

    @Override
    public BigDecimal getFeeForDate(LocalDate date) {
        return repository.findFeeForDate(date)
                .map(Fee::getFeeAmount)
                .orElse(BigDecimal.ZERO);
    }
}
