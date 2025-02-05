package com.directa24.main_challenge.directorsmoviesapi;

import com.directa24.main_challenge.exceptions.BadRequestException;
import com.directa24.main_challenge.exceptions.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Component
public class FeignErrorHandler implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String methodKey, Response response) {
        String errorMessage = "Unknown error";
        // Try to read the response body as a string (if available)
        try (Reader reader = new InputStreamReader(response.body().asInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
            errorMessage = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return switch (response.status()) {
            case 400 -> new BadRequestException(errorMessage);
            case 404 -> new NotFoundException(errorMessage);
            case 500,501,502,503,504 -> new DirectorsMoviesApiDownException(errorMessage);
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
