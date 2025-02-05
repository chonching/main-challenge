package com.directa24.main_challenge.directorsmoviesapi;

public class DirectorsMoviesApiDownException extends RuntimeException{

    private static final String DEFAULT_MSG = "DirectorsMoviesApi service down";
    public DirectorsMoviesApiDownException() {
        super(DEFAULT_MSG);
    }

    public DirectorsMoviesApiDownException(String message) {
        super(message);
    }

    public DirectorsMoviesApiDownException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectorsMoviesApiDownException(Throwable cause) {
        super(cause);
    }
}
