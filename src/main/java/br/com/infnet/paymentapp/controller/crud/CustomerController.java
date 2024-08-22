package br.com.infnet.paymentapp.controller.crud;

import br.com.infnet.paymentapp.dto.converter.InboundConverter;
import br.com.infnet.paymentapp.dto.converter.OutboundConverter;
import br.com.infnet.paymentapp.dto.rest.CustomerModel;
import br.com.infnet.paymentapp.model.Customer;
import br.com.infnet.paymentapp.service.endpoint.CrudOperationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer", description = "The customer management api")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController extends BasicCrud<CustomerModel, CustomerModel, Customer, UUID> {

    public CustomerController(CrudOperationService<Customer, UUID> crudOperationService,
                              InboundConverter<CustomerModel, Customer> inboundConverter,
                              OutboundConverter<Customer, CustomerModel> outboundConverter) {
        super(crudOperationService, inboundConverter, outboundConverter);
    }

    @Override
    @GetMapping("/{id}")
    public CustomerModel findById(@PathVariable("id") UUID id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public List<CustomerModel> findAll() {
        return super.findAll();
    }

    @Override
    @PostMapping
    public CustomerModel create(@RequestBody CustomerModel model) {
        return super.create(model);
    }

    @Override
    @PutMapping("/{id}")
    public CustomerModel update(@PathVariable("id") UUID id, @RequestBody CustomerModel model) {
        return super.update(id, model);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        super.delete(id);
    }
}
