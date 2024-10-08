package br.com.infnet.paymentapp.controller.crud;

import br.com.infnet.paymentapp.dto.converter.InboundConverter;
import br.com.infnet.paymentapp.dto.converter.OutboundConverter;
import br.com.infnet.paymentapp.dto.rest.PaymentModel;
import br.com.infnet.paymentapp.model.Payment;
import br.com.infnet.paymentapp.service.PaymentCrudService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/payments")
@Tag(name = "Payment", description = "The Payment management api")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController extends BasicCrud<PaymentModel, PaymentModel, Payment, UUID> {

    public PaymentController(PaymentCrudService crudOperationService,
                             InboundConverter<PaymentModel, Payment> inboundConverter,
                             OutboundConverter<Payment, PaymentModel> outboundConverter) {
        super(crudOperationService, inboundConverter, outboundConverter);
    }

    @Override
    @GetMapping("/{id}")
    public PaymentModel findById(@PathVariable("id") UUID id) {
        return super.findById(id);
    }

    @GetMapping
    public List<PaymentModel> findAll(@RequestParam("orderId") Optional<UUID> orderId) {
        return orderId.map(uuid -> ((PaymentCrudService) crudOperationService)
                        .findByOrderId(uuid)
                        .stream()
                        .map(outboundConverter::convert)
                        .toList())
                .orElseGet(super::findAll);
    }

    @Override
    @PostMapping
    public PaymentModel create(@RequestBody PaymentModel model) {
        return super.create(model);
    }

    @Override
    @PutMapping("/{id}")
    public PaymentModel update(@PathVariable("id") UUID id, @RequestBody PaymentModel model) {
        return super.update(id, model);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        super.delete(id);
    }
}
