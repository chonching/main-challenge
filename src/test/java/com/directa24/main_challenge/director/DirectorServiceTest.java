package com.directa24.main_challenge.director;

import com.directa24.main_challenge.directorsmoviesapi.DirectorsMoviesApiDownException;
import com.directa24.main_challenge.directorsmoviesapi.DirectorsMoviesApiResponse;
import com.directa24.main_challenge.directorsmoviesapi.DirectorsMoviesFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DirectorServiceTest {

    private DirectorServiceImpl directorServiceImpl;
    @Mock
    private DirectorsMoviesFeignClient directorsMoviesFeignClient;

    @BeforeEach
    public void setup(){
        this.directorServiceImpl = new DirectorServiceImpl(directorsMoviesFeignClient);
    }

    @Nested
    class TestGetDirectors {

        @Test
        public void testGetDirectors() throws JsonProcessingException {
            Mockito.when(directorsMoviesFeignClient.getDirectors(1))
                    .thenReturn(getResponse());
            DirectorResponse response = directorServiceImpl.getDirectors(1, 2);
            Assertions.assertNotNull(response);
            Assertions.assertEquals(2, response.getDirectors().size());
        }

        @Test
        public void testGetDirectorsBadRequestError() throws JsonProcessingException {
            Mockito.when(directorsMoviesFeignClient.getDirectors(1))
                    .thenThrow(DirectorsBadRequestException.class);
            Assertions.assertThrows(DirectorsBadRequestException.class, () -> directorServiceImpl.getDirectors(1, 2));
        }

        @Test
        public void testGetDirectorsNotFoundError() throws JsonProcessingException {
            Mockito.when(directorsMoviesFeignClient.getDirectors(1))
                    .thenThrow(DirectorsNotFoundException.class);
            Assertions.assertThrows(DirectorsNotFoundException.class, () -> directorServiceImpl.getDirectors(1, 2));
        }

        @Test
        public void testGetDirectorsApiDownError() throws JsonProcessingException {
            Mockito.when(directorsMoviesFeignClient.getDirectors(1))
                    .thenThrow(DirectorsMoviesApiDownException.class);
            Assertions.assertThrows(DirectorsMoviesApiDownException.class, () -> directorServiceImpl.getDirectors(1, 2));
        }

        private DirectorsMoviesApiResponse getResponse(){
            return DirectorsMoviesApiResponse.builder()
                    .page(2)
                    .perPage(10)
                    .total(26)
                    .total(3)
                    .data(getData())
                    .build();
        }

        private List<DirectorsMoviesApiResponse.Data> getData(){
            return List.of(
                    DirectorsMoviesApiResponse.Data.builder()
                            .title("a")
                            .year("2011")
                            .rated("Not Rated")
                            .released("27 Mar 2011")
                            .runtime("231 min")
                            .genre("Action, Crime")
                            .director("antonio")
                            .writer("antonio")
                            .actors("antonio").build(),
                    DirectorsMoviesApiResponse.Data.builder()
                            .title("b")
                            .year("2021")
                            .rated("Not Rated")
                            .released("2 Apr 2021")
                            .runtime("201 min")
                            .genre("Action, Crime")
                            .director("marlon")
                            .writer("marlon")
                            .actors("marlon").build(),
                    DirectorsMoviesApiResponse.Data.builder()
                            .title("c")
                            .year("2011")
                            .rated("Not Rated")
                            .released("27 Mar 2011")
                            .runtime("231 min")
                            .genre("Action, Crime")
                            .director("ben")
                            .writer("ben")
                            .actors("ben").build(),
                    DirectorsMoviesApiResponse.Data.builder()
                            .title("d")
                            .year("2011")
                            .rated("Not Rated")
                            .released("27 Mar 2011")
                            .runtime("231 min")
                            .genre("Action, Crime")
                            .director("marlon")
                            .writer("marlon")
                            .actors("marlon").build());
        }
    }
}
