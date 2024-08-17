package br.com.infnet.paymentapp.loader;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLoaderMain {

    private final LoaderChainStarter loaderChainStarter;

    @PostConstruct
    public void startLoading() {
        loaderChainStarter.startLoaderChain();
    }
}
