package br.com.infnet.paymentapp.loader;

import br.com.infnet.paymentapp.dto.csv.Csv;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public abstract class LoaderLink<T extends Csv> {

    public abstract void doLoad();

    protected <N extends Csv> LoaderLink<N> getNextLink() {
        return null;
    }

    public void load() {
        doLoad();
        Optional.ofNullable(getNextLink()).ifPresentOrElse(
                LoaderLink::load,
                () -> log.info("End of the chain"));
    }


}
