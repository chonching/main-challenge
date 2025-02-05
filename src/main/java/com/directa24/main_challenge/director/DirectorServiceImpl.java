package com.directa24.main_challenge.director;

import com.directa24.main_challenge.directorsmoviesapi.DirectorsMoviesApiResponse;
import com.directa24.main_challenge.directorsmoviesapi.DirectorsMoviesFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorsMoviesFeignClient directorsMoviesFeignClient;

    @Override
    public DirectorResponse getDirectors(int page, int threshold) {
        DirectorsMoviesApiResponse apiResponse = directorsMoviesFeignClient.getDirectors(page);
        Map<String, Long> directorCount = Objects.requireNonNull(apiResponse).getData().stream()
                .collect(Collectors.groupingBy(DirectorsMoviesApiResponse.Data::getDirector, Collectors.counting()));

        List<String> directorsList = apiResponse.getData().stream()
                .sorted(Comparator.comparing(DirectorsMoviesApiResponse.Data::getDirector))
                .map(DirectorsMoviesApiResponse.Data::getDirector)
                .filter(director -> directorCount.get(director) > threshold).toList();

        return DirectorResponse.builder().directors(directorsList).build();
    }
}
