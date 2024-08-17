package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.csv.PaymentCsv;
import br.com.infnet.paymentapp.dto.rest.PaymentModel;
import br.com.infnet.paymentapp.model.CardPayment;
import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.model.PixPayment;
import org.mapstruct.Mapper;

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
        return null;
    }

    @Override
    public Payment convert(PaymentModel source) {
        return null;
    }

    public abstract CardPayment convertCardPayment(PaymentCsv source);

    public abstract PixPayment convertPixPayment(PaymentCsv source);

}
