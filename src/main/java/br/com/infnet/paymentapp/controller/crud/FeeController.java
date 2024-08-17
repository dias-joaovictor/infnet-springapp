package br.com.infnet.paymentapp.controller.crud;

import br.com.infnet.paymentapp.dto.converter.InboundConverter;
import br.com.infnet.paymentapp.dto.converter.OutboundConverter;
import br.com.infnet.paymentapp.dto.rest.FeeModel;
import br.com.infnet.paymentapp.model.Fee;
import br.com.infnet.paymentapp.service.endpoint.CrudOperationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fees")
@Tag(name = "Fee", description = "The fee management api")
public class FeeController extends BasicCrud<FeeModel, FeeModel, Fee, UUID> {

    public FeeController(CrudOperationService<Fee, UUID> crudOperationService,
                         InboundConverter<FeeModel, Fee> inboundConverter,
                         OutboundConverter<Fee, FeeModel> outboundConverter) {
        super(crudOperationService, inboundConverter, outboundConverter);
    }

    @Override
    @GetMapping("/{id}")
    public FeeModel findById(@PathVariable("id") UUID id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public List<FeeModel> findAll() {
        return super.findAll();
    }

    @Override
    @PostMapping
    public FeeModel create(@RequestBody FeeModel model) {
        return super.create(model);
    }

    @Override
    @PutMapping("/{id}")
    public FeeModel update(@PathVariable("id") UUID id, @RequestBody FeeModel model) {
        return super.update(id, model);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        super.delete(id);
    }
}
