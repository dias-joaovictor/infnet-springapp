package br.com.infnet.paymentapp.controller.crud;

import br.com.infnet.paymentapp.dto.converter.InboundConverter;
import br.com.infnet.paymentapp.dto.converter.OutboundConverter;
import br.com.infnet.paymentapp.dto.rest.OrderModel;
import br.com.infnet.paymentapp.model.Order;
import br.com.infnet.paymentapp.service.endpoint.CrudOperationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order", description = "The Order management api")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController extends BasicCrud<OrderModel, OrderModel, Order, UUID> {

    public OrderController(CrudOperationService<Order, UUID> crudOperationService,
                           InboundConverter<OrderModel, Order> inboundConverter,
                           OutboundConverter<Order, OrderModel> outboundConverter) {
        super(crudOperationService, inboundConverter, outboundConverter);
    }

    @Override
    @GetMapping("/{id}")
    public OrderModel findById(@PathVariable("id") UUID id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public List<OrderModel> findAll() {
        return super.findAll();
    }

    @Override
    @PostMapping
    public OrderModel create(@RequestBody OrderModel model) {
        return super.create(model);
    }

    @Override
    @PutMapping("/{id}")
    public OrderModel update(@PathVariable("id") UUID id, @RequestBody OrderModel model) {
        return super.update(id, model);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        super.delete(id);
    }
}
