package com.directa24.main_challenge.director;

import com.directa24.main_challenge.exceptions.NotFoundException;

public class DirectorsNotFoundException extends NotFoundException {

    private static final String DEFAULT_MSG = "Directors not found";
    public DirectorsNotFoundException() {
        super(DEFAULT_MSG);
    }

    public DirectorsNotFoundException(String message) {
        super(message);
    }

    public DirectorsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectorsNotFoundException(Throwable cause) {
        super(cause);
    }
}
