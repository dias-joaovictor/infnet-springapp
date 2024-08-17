package br.com.infnet.paymentapp.service.csv;

import br.com.infnet.paymentapp.model.ModelEntity;

public interface CsvConvertedEntityPersisterService<E extends ModelEntity> {
    void save(E entity);
}
