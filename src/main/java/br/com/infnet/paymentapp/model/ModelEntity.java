package br.com.infnet.paymentapp.model;

import java.io.Serializable;

public interface ModelEntity<ID extends Serializable> {

    ID getId();

    void setId(ID id);
}
