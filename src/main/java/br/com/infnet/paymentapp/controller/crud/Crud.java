package br.com.infnet.paymentapp.controller.crud;

import br.com.infnet.paymentapp.dto.rest.RequestModel;
import br.com.infnet.paymentapp.dto.rest.ResponseModel;

import java.io.Serializable;
import java.util.List;

public interface Crud<REQ extends RequestModel, RESP extends ResponseModel, ID extends Serializable> {

    RESP create(REQ model);

    RESP update(ID id, REQ model);

    void delete(ID id);

    RESP findById(ID id);

    List<RESP> findAll();

}
