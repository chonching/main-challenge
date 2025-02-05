package com.directa24.main_challenge.director;

import com.directa24.main_challenge.exceptions.BadRequestException;

public class DirectorsBadRequestException extends BadRequestException {

    private static final String DEFAULT_MSG = "Directors bad request";
    public DirectorsBadRequestException() {
        super(DEFAULT_MSG);
    }

    public DirectorsBadRequestException(String message) {
        super(message);
    }

    public DirectorsBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectorsBadRequestException(Throwable cause) {
        super(cause);
    }
}
