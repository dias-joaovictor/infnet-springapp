package br.com.infnet.paymentapp.loader.impl;

import br.com.infnet.paymentapp.dto.csv.Csv;
import br.com.infnet.paymentapp.loader.LoaderLink;
import lombok.RequiredArgsConstructor;

/**
 * @param <C> current link loader
 * @param <N> next link loader
 */
@RequiredArgsConstructor
public abstract class LoaderChain<C extends Csv, N extends Csv> {

    private final LoaderLink<C> currentLoaderLink;

    private final LoaderLink<N> nextLoaderLink;

    public void load() {
        
    }

}
