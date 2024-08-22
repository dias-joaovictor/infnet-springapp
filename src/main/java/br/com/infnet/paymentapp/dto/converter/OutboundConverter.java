package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.rest.ResponseModel;
import br.com.infnet.paymentapp.model.ModelEntity;

public interface OutboundConverter<E extends ModelEntity, R extends ResponseModel> {
    R convert(E entity);
}
