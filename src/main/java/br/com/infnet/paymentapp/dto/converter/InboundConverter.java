package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.rest.RequestModel;
import br.com.infnet.paymentapp.model.ModelEntity;

public interface InboundConverter<R extends RequestModel, E extends ModelEntity> {
    E convert(R source);
}
