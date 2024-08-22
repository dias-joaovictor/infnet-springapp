package br.com.infnet.paymentapp.controller.crud;

import br.com.infnet.paymentapp.dto.converter.InboundConverter;
import br.com.infnet.paymentapp.dto.converter.OutboundConverter;
import br.com.infnet.paymentapp.dto.rest.RequestModel;
import br.com.infnet.paymentapp.dto.rest.ResponseModel;
import br.com.infnet.paymentapp.model.ModelEntity;
import br.com.infnet.paymentapp.service.endpoint.CrudOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class BasicCrud<REQ extends RequestModel,
        RESP extends ResponseModel,
        E extends ModelEntity,
        ID extends Serializable> implements Crud<REQ, RESP, ID> {

    protected final CrudOperationService<E, ID> crudOperationService;
    protected final InboundConverter<REQ, E> inboundConverter;
    protected final OutboundConverter<E, RESP> outboundConverter;

    @Override
    public RESP findById(@PathVariable("id") ID id) {
        return outboundConverter.convert(crudOperationService.crudFindById(id));
    }

    @Override
    public List<RESP> findAll() {
        return crudOperationService
                .crudFindAll()
                .stream()
                .map(outboundConverter::convert)
                .toList();
    }

    @Override
    public RESP create(@RequestBody REQ model) {
        return outboundConverter.convert(crudOperationService.crudSave(inboundConverter.convert(model)));
    }

    @Override
    public RESP update(@PathVariable("id") ID id, @RequestBody REQ model) {
        return outboundConverter.convert(crudOperationService.crudUpdate(id, inboundConverter.convert(model)));
    }

    @Override
    public void delete(@PathVariable("id") ID id) {
        crudOperationService.crudDeleteById(id);
    }

}
