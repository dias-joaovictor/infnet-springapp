package br.com.infnet.paymentapp.exception;


public class NullEntityException extends InvalidEntityException {

    public NullEntityException(Class<?> clazz) {
        super(clazz, "its null");
    }
}
