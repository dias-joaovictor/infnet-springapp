package br.com.infnet.paymentapp.configuration;

import br.com.infnet.paymentapp.dto.csv.CustomerCsv;
import br.com.infnet.paymentapp.dto.csv.FeeCsv;
import br.com.infnet.paymentapp.dto.csv.OrderCsv;
import br.com.infnet.paymentapp.dto.csv.PaymentCsv;
import br.com.infnet.paymentapp.loader.resource.AbstractCsvParser;
import br.com.infnet.paymentapp.loader.resource.CsvParser;
import br.com.infnet.paymentapp.service.csv.CsvParserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ParsersConfig {

    @Value("classpath:loaders/fees.csv")
    private Resource feesCsvResource;

    @Value("classpath:loaders/customers.csv")
    private Resource customersCsvResource;

    @Value("classpath:loaders/orders.csv")
    private Resource ordersCsvResource;

    @Value("classpath:loaders/payments.csv")
    private Resource paymentsCsvResource;

    @Bean
    public CsvParser<FeeCsv> feesCsvParser(CsvParserService<FeeCsv> csvParserService) {
        return new AbstractCsvParser<>(csvParserService) {
            @Override
            protected Resource getResource() {
                return feesCsvResource;
            }
        };
    }

    @Bean
    public CsvParser<CustomerCsv> customersCsvParser(CsvParserService<CustomerCsv> csvParserService) {
        return new AbstractCsvParser<>(csvParserService) {
            @Override
            protected Resource getResource() {
                return customersCsvResource;
            }
        };
    }

    @Bean
    public CsvParser<OrderCsv> ordersCsvParser(CsvParserService<OrderCsv> csvParserService) {
        return new AbstractCsvParser<>(csvParserService) {
            @Override
            protected Resource getResource() {
                return ordersCsvResource;
            }
        };
    }

    @Bean
    public CsvParser<PaymentCsv> paymentCsvCsvParser(CsvParserService<PaymentCsv> csvParserService) {
        return new AbstractCsvParser<>(csvParserService) {
            @Override
            protected Resource getResource() {
                return paymentsCsvResource;
            }
        };
    }

}
