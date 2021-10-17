package com.nabil.udemy.ecommerce.orderservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Resource400BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 5054443378538216172L;

    public Resource400BadRequestException(String message) {
        super(message);
    }

}
