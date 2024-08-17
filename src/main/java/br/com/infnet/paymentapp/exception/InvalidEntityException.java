package br.com.infnet.paymentapp.exception;


public class InvalidEntityException extends RuntimeException {

    public InvalidEntityException(Class<?> clazz, String message) {
        super("Entity %s is invalid due to: %s".formatted(clazz.getSimpleName(), message));
    }
}
