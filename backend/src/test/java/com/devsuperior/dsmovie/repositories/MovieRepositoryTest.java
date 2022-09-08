package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.domain.Movie;
import com.devsuperior.dsmovie.util.MovieCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@DisplayName("Tests for Movie Repository")
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @DisplayName("FindAll returns list page of Movies when Sucessful")
    void findAll_ReturnsPageOfMovies_WhenSucessful() {
        Movie movieToBeSaved = MovieCreator.movieCreator();
        
        this.movieRepository.save(movieToBeSaved);

        Pageable pageable = Pageable.ofSize(5);

        Page<Movie> movies = this.movieRepository.findAll(pageable);

        Assertions.assertFalse(movies.isEmpty());

        Assertions.assertEquals(movieToBeSaved.getId(), movies.toList().get(0).getId());
        Assertions.assertEquals(movieToBeSaved.getTitle(), movies.toList().get(0).getTitle());
        Assertions.assertEquals(movieToBeSaved.getScore(), movies.toList().get(0).getScore());
        Assertions.assertEquals(movieToBeSaved.getCount(), movies.toList().get(0).getCount());
        Assertions.assertEquals(movieToBeSaved.getImage(), movies.toList().get(0).getImage());
    }

    @Test
    @DisplayName("FindById return Movie when Sucessful")
    void findById_ReturnsMovie_WhenSucessful() {

        Movie movieToBeSaved = MovieCreator.movieCreator();
        
        this.movieRepository.save(movieToBeSaved);

        Movie movies = this.movieRepository.findById(movieToBeSaved.getId()).get();

        Assertions.assertEquals(movieToBeSaved.getId(), movies.getId());
        Assertions.assertEquals(movieToBeSaved.getTitle(), movies.getTitle());
        Assertions.assertEquals(movieToBeSaved.getScore(), movies.getScore());
        Assertions.assertEquals(movieToBeSaved.getCount(), movies.getCount());
        Assertions.assertEquals(movieToBeSaved.getImage(), movies.getImage());
    }
}
