package com.directa24.main_challenge.directorsmoviesapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorsMoviesApiResponse {

    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private List<Data> data = Collections.emptyList() ;

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        @JsonProperty("Title")
        private String title;
        @JsonProperty("Year")
        private String year;
        @JsonProperty("Rated")
        private String rated;
        @JsonProperty("Released")
        private String released;
        @JsonProperty("Runtime")
        private String runtime;
        @JsonProperty("Genre")
        private String genre;
        @JsonProperty("Director")
        private String director;
        @JsonProperty("Writer")
        private String writer;
        @JsonProperty("Actors")
        private String actors;
    }
}
