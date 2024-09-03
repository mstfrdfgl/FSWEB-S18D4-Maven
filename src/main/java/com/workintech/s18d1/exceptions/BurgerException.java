package com.workintech.s18d1.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BurgerException extends RuntimeException {

    private HttpStatus httpStatus;

    public BurgerException(HttpStatus status) {
        this.httpStatus = status;
    }

    public BurgerException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

}
