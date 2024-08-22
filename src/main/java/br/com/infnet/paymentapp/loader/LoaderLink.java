package br.com.infnet.paymentapp.loader;

public interface LoaderLink<T extends ChainLink> {
    void handle();
}
