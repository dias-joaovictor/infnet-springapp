package br.com.infnet.paymentapp.loader;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLoaderMain {

    private final ChainStarter chainStarter;

    @PostConstruct
    public void startLoading() {
        chainStarter.startChain();
    }
}
