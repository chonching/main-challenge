package com.directa24.main_challenge.director;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DirectorController {

    DirectorService directorService;

    @GetMapping
    public ResponseEntity<DirectorResponse> getDirectors(@RequestParam int page, @RequestParam int threshold){
        return ResponseEntity.ok().body(directorService.getDirectors(page, threshold));
    }
}
