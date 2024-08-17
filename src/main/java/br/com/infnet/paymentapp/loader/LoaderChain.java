package br.com.infnet.paymentapp.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @param <C> current chain link
 */
@Slf4j
public abstract class LoaderChain<C extends ChainLink> {

    private final LoaderChain<?> nextLoaderLink;

    protected LoaderChain(
            @Nullable LoaderChain<?> nextLoaderLink) {
        this.nextLoaderLink = nextLoaderLink;
    }

    protected abstract void handle();

    @Transactional
    public void load() {
        handle();
        Optional.ofNullable(nextLoaderLink)
                .ifPresentOrElse(LoaderChain::load,
                        () -> log.info("End of the chain"));
    }
}
