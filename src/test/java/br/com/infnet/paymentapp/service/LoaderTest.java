package br.com.infnet.paymentapp.service;


import br.com.infnet.paymentapp.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class LoaderTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:loader/customer.json")
    private Resource customerJsonFile;

    @Value("classpath:loader/fee.json")
    private Resource feeJsonFile;

    @Value("classpath:loader/pix_payment.json")
    private Resource pixPaymentJsonFile;

    @Value("classpath:loader/card_payment.json")
    private Resource cardPaymentJsonFile;

    @Value("classpath:loader/order.json")
    private Resource orderJsonFile;

    @Test
    void loadCustomer(){
        // arrange

        // act
        var customers = loadListJson(customerJsonFile, Customer.class);

        // assert
        var expectedCustomers = List.of(
                Customer.builder()
                        .id(UUID.fromString("d290f1ee-6c54-4b01-90e6-d701748f0851"))
                        .fullName("Alice Johnson")
                        .dateOfBirth(LocalDate.parse("1985-03-15"))
                        .enabled(true)
                        .build(),
                Customer.builder()
                        .id(UUID.fromString("ec0b1b9b-0b76-4d5f-98f8-216116f5b3f1"))
                        .fullName("Bob Smith")
                        .dateOfBirth(LocalDate.parse("1990-07-22"))
                        .enabled(false)
                        .build(),
                Customer.builder()
                        .id(UUID.fromString("8e1c9d61-5394-4f8a-8f9d-1a60d5b0e840"))
                        .fullName("Carol Williams")
                        .dateOfBirth(LocalDate.parse("1978-12-05"))
                        .enabled(true)
                        .build()
        );
        assertThat(customers)
                .hasSize(3)
                .usingRecursiveComparison()
                .isEqualTo(expectedCustomers);
        log.info(customers.toString());
    }

    @Test
    void loadFee(){
        // arrange

        // act
        var fees = loadListJson(feeJsonFile, Fee.class);

        // assert
        var expectedFees = List.of(
                Fee.builder()
                        .id(UUID.fromString("f1a4c5d3-6c54-4b01-90e6-d701748f0851"))
                        .feeAmount(new BigDecimal("100.50"))
                        .fromDate(LocalDate.parse("2023-01-01"))
                        .build(),
                Fee.builder()
                        .id(UUID.fromString("d8b7a8e4-0b76-4d5f-98f8-216116f5b3f1"))
                        .feeAmount(new BigDecimal("250.75"))
                        .fromDate(LocalDate.parse("2023-02-15"))
                        .build(),
                Fee.builder()
                        .id(UUID.fromString("c4d9e7f6-5394-4f8a-8f9d-1a60d5b0e840"))
                        .feeAmount(new BigDecimal("300.00"))
                        .fromDate(LocalDate.parse("2023-03-20"))
                        .build()
        );
        assertThat(fees)
                .hasSize(3)
                .usingRecursiveComparison()
                .isEqualTo(expectedFees);
        log.info(fees.toString());
    }

    @Test
    void loadPixPayment(){
        // arrange

        // act
        var pixPayment = loadJson(pixPaymentJsonFile, PixPayment.class);

        // assert
        var expectedPixPayment = PixPayment.builder()
                .id(UUID.fromString("d290f1ee-6c54-4b01-90e6-d701748f0851"))
                .amount(new BigDecimal("167.50"))
                .pixKey("E78172CF-D35D-4CE6-AC99-FF8624B64A90")
                .build();
        assertThat(pixPayment)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .isEqualTo(expectedPixPayment);
        log.info(pixPayment.toString());
    }

    @Test
    void loadCardPayment(){
        // arrange

        // act
        var cardPayment = loadJson(cardPaymentJsonFile, CardPayment.class);

        // assert
        var expectedCardPayment = CardPayment.builder()
                .id(UUID.fromString("a1b2c3d4-5678-90ab-cdef-1234567890ab"))
                .amount(new BigDecimal("150.75"))
                .cardHash("abcdef1234567890")
                .cardholderName("John Doe")
                .expiryDate(LocalDate.parse("2025-12-31"))
                .build();

        assertThat(cardPayment)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .isEqualTo(expectedCardPayment);
        log.info(cardPayment.toString());
    }

    @Test
    void loadOrder() {
        // arrange

        // act
        var order = loadJson(orderJsonFile, Order.class);

        // assert
        var expectedOrder = Order.builder()
                .id(UUID.fromString("d290f1ee-6c54-4b01-90e6-d701748f0851"))
                .orderDate(LocalDate.of(2023, 7, 15))
                .amount(new BigDecimal("500.00"))
                .fee(new BigDecimal("25.00"))
                .totalAmount(new BigDecimal("525.00"))
                .customer(Customer.builder()
                        .id(UUID.fromString("f1a4c5d3-6c54-4b01-90e6-d701748f0851"))
                        .fullName("Alice Johnson")
                        .dateOfBirth(LocalDate.parse("1985-03-15"))
                        .enabled(true)
                        .build())
                .payments(List.of(
                        CardPayment.builder()
                            .id(UUID.fromString("a1b2c3d4-5678-90ab-cdef-1234567890ab"))
                            .amount(new BigDecimal("150.75"))
                            .cardHash("abcdef1234567890")
                            .cardholderName("John Doe")
                            .expiryDate(LocalDate.parse("2025-12-31"))
                            .build(),
                        CardPayment.builder()
                                .id(UUID.fromString("b2c3d4e5-6789-0abc-def1-2345678901bc"))
                                .amount(new BigDecimal("200.00"))
                                .cardHash("1234567890abcdef")
                                .cardholderName("Jane Smith")
                                .expiryDate(LocalDate.parse("2024-06-30"))
                                .build()
                        ))
                .build();

        assertThat(order)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .isEqualTo(expectedOrder);

        log.info(order.toString());
    }

    @SneakyThrows
    private <T> T loadJson(Resource resource, Class<T> clazz) {
        return objectMapper.readValue(resource.getInputStream(), clazz);
    }

    @SneakyThrows
    private <T> List<T> loadListJson(Resource resource, Class<T> clazz) {
        return objectMapper.readValue(
                resource.getInputStream(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
