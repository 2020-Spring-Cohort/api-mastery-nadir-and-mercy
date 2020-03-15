package org.wcci.apimastery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MovieController {
    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @RequestMapping("/movies")
    public Collection<Movie> retrieveMovies(){
        return (Collection<Movie>) movieRepository.findAll();
    }
}
