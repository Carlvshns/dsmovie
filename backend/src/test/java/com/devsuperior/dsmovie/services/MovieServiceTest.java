package com.devsuperior.dsmovie.services;

import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmovie.domain.Movie;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.util.MovieCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepositoryMock;

    @BeforeEach
    void setUp(){

        PageImpl<Movie> moviePage = new PageImpl<>(List.of(MovieCreator.movieCreator()));

        BDDMockito.when(movieRepositoryMock.findById(ArgumentMatchers.anyLong()))
        .thenReturn(Optional.of(MovieCreator.movieCreator()));

        BDDMockito.when(movieRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
        .thenReturn(moviePage);

    }

    @Test
    @DisplayName("findAll returns list of movie inside page object when sucessful")
    void findAll_ReturnsListOfMoviesInsidePageObect_WhenSucessful() {

        Movie expectedMovie = MovieCreator.movieCreator();
        Page<MovieDTO> moviePage = movieService.findAll(PageRequest.of(1, 1));

        Assertions.assertNotNull(moviePage);
        Assertions.assertFalse(moviePage.toList().isEmpty());
        Assertions.assertEquals(1, moviePage.toList().size());
        Assertions.assertEquals(expectedMovie.getId(), moviePage.toList().get(0).getId());
        Assertions.assertEquals(expectedMovie.getTitle(), moviePage.toList().get(0).getTitle());
        Assertions.assertEquals(expectedMovie.getScore(), moviePage.toList().get(0).getScore());
        Assertions.assertEquals(expectedMovie.getCount(), moviePage.toList().get(0).getCount());
        Assertions.assertEquals(expectedMovie.getImage(), moviePage.toList().get(0).getImage());
    }

    @Test
    @DisplayName("findById returns movie when sucessful")
    void findById_ReturnsMovie_WhenSucessful() {

        Movie expectedMovie = MovieCreator.movieCreator();
        MovieDTO movies = movieService.findById(1L);

        Assertions.assertNotNull(movies);

        Assertions.assertEquals(expectedMovie.getId(), movies.getId());
        Assertions.assertEquals(expectedMovie.getTitle(), movies.getTitle());
        Assertions.assertEquals(expectedMovie.getScore(), movies.getScore());
        Assertions.assertEquals(expectedMovie.getCount(), movies.getCount());
        Assertions.assertEquals(expectedMovie.getImage(), movies.getImage());
    }
}
