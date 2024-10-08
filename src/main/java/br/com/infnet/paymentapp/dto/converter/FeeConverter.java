package br.com.infnet.paymentapp.dto.converter;

import br.com.infnet.paymentapp.dto.csv.FeeCsv;
import br.com.infnet.paymentapp.dto.rest.FeeModel;
import br.com.infnet.paymentapp.model.Fee;
import org.mapstruct.Mapper;

@Mapper
public interface FeeConverter extends CsvConverter<FeeCsv, Fee>,
        InboundConverter<FeeModel, Fee>,
        OutboundConverter<Fee, FeeModel> {
}
