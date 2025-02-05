package com.directa24.main_challenge.directorsmoviesapi;

import com.directa24.main_challenge.director.DirectorsBadRequestException;
import com.directa24.main_challenge.director.DirectorsNotFoundException;
import com.directa24.main_challenge.exceptions.BadRequestException;
import com.directa24.main_challenge.exceptions.NotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value="directors-movies-api", url="${directors.movies.apiUrl}", configuration = FeignErrorHandler.class)
public interface DirectorsMoviesFeignClient {

    @GetMapping(value="/movies/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @CircuitBreaker(name="directors-movies-api", fallbackMethod = "directorsMoviesApiFallback")
    DirectorsMoviesApiResponse getDirectors(@RequestParam("page") int page);

    default ResponseEntity<Map<String, Object>> directorsMoviesApiFallback(Exception e) {
        if (e instanceof BadRequestException) {
            throw new DirectorsBadRequestException(e.getMessage());
        } else if (e instanceof NotFoundException) {
            throw new DirectorsNotFoundException(e.getMessage());
        } else {
            throw new DirectorsMoviesApiDownException();
        }
    }
}
