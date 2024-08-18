package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.csv.PaymentCsv;
import br.com.infnet.paymentapp.dto.rest.CardPaymentModel;
import br.com.infnet.paymentapp.dto.rest.PaymentModel;
import br.com.infnet.paymentapp.dto.rest.PixPaymentModel;
import br.com.infnet.paymentapp.model.CardPayment;
import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.model.PixPayment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class PaymentConverter implements CsvConverter<PaymentCsv, Payment>,
        InboundConverter<PaymentModel, Payment>,
        OutboundConverter<Payment, PaymentModel> {

    @Override
    public Payment convert(PaymentCsv source) {
        if (PaymentCsv.Type.CARD == source.getType()) {
            return convertCardPayment(source);
        } else if (PaymentCsv.Type.PIX == source.getType()) {
            return convertPixPayment(source);
        } else {
            throw new IllegalArgumentException("Unsupported PaymentCsv subtype: " + source.getClass().getName());
        }
    }

    @Override
    public PaymentModel convert(Payment entity) {
        return switch (entity) {
            case PixPayment payment -> convertPixPayment(payment);
            case CardPayment payment -> convertCardPayment(payment);
            default -> throw new IllegalStateException("Unexpected value: " + entity);
        };
    }

    @Override
    public Payment convert(PaymentModel source) {
        return switch (source) {
            case PixPaymentModel model -> convertPixPayment(model);
            case CardPaymentModel model -> convertCardPayment(model);
            default -> throw new IllegalStateException("Unexpected value: " + source);
        };
    }

    public abstract CardPayment convertCardPayment(PaymentCsv source);

    @Mapping(source = "order.id", target = "orderId")
    public abstract CardPaymentModel convertCardPayment(CardPayment source);

    public abstract CardPayment convertCardPayment(CardPaymentModel source);

    public abstract PixPayment convertPixPayment(PaymentCsv source);

    @Mapping(source = "order.id", target = "orderId")
    public abstract PixPaymentModel convertPixPayment(PixPayment source);

    public abstract PixPayment convertPixPayment(PixPaymentModel source);
}
