package br.com.infnet.paymentapp.exception;


import java.io.Serializable;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(Class<?> clazz, Serializable id) {
        super("Entity %s already exists with id %s".formatted(clazz.getSimpleName(), id));
    }
}
