package com.synacy.moviehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by steven on 5/13/17.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NoContentFoundException extends RuntimeException {
    public NoContentFoundException(String message) {
        super(message);
    }
}
