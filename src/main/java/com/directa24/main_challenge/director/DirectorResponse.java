package com.directa24.main_challenge.director;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorResponse {

    private List<String> directors = new ArrayList<>();
}
