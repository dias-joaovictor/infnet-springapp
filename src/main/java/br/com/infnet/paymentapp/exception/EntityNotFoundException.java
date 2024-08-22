package br.com.infnet.paymentapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> clazz, Serializable id) {
        super("Entity %s with id %s was not found".formatted(clazz.getSimpleName(), id));
    }
}
