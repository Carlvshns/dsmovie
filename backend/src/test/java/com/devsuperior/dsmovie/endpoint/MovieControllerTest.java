package com.devsuperior.dsmovie.endpoint;

import java.util.List;

import com.devsuperior.dsmovie.domain.Movie;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieServiceMock;

    @BeforeEach
    void setUp(){

        PageImpl<Movie> moviePage = new PageImpl<>(List.of(MovieCreator.movieCreator()));
        Page<MovieDTO> movieDTOPage = moviePage.map(x -> new MovieDTO(x));

        BDDMockito.when(movieServiceMock.findAll(ArgumentMatchers.any(PageRequest.class)))
        .thenReturn(movieDTOPage);

        BDDMockito.when(movieServiceMock.findById(ArgumentMatchers.anyLong()))
        .thenReturn(MovieCreator.movieDTOCreator());

    }

    @Test
    @DisplayName("findAll returns list of movie inside page object when sucessful")
    void findAll_ReturnsListOfMoviesInsidePageObect_WhenSucessful() {

        Movie expectedMovie = MovieCreator.movieCreator();
        ResponseEntity<Page<MovieDTO>> moviePage = movieController.findAll(PageRequest.of(1, 1));

        Assertions.assertNotNull(moviePage);
        Assertions.assertFalse(moviePage.getBody().isEmpty());
        Assertions.assertEquals(expectedMovie.getId(), moviePage.getBody().getContent().get(0).getId());
        Assertions.assertEquals(expectedMovie.getTitle(), moviePage.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals(expectedMovie.getScore(), moviePage.getBody().getContent().get(0).getScore());
        Assertions.assertEquals(expectedMovie.getCount(), moviePage.getBody().getContent().get(0).getCount());
        Assertions.assertEquals(expectedMovie.getImage(), moviePage.getBody().getContent().get(0).getImage());
    }

    @Test
    @DisplayName("findById returns movie when sucessful")
    void findById_ReturnsMovie_WhenSucessful() {

        Movie expectedMovie = MovieCreator.movieCreator();
        ResponseEntity<MovieDTO> movies = movieController.findById(1L);

        Assertions.assertNotNull(movies);

        Assertions.assertEquals(expectedMovie.getId(), movies.getBody().getId());
        Assertions.assertEquals(expectedMovie.getTitle(), movies.getBody().getTitle());
        Assertions.assertEquals(expectedMovie.getScore(), movies.getBody().getScore());
        Assertions.assertEquals(expectedMovie.getCount(), movies.getBody().getCount());
        Assertions.assertEquals(expectedMovie.getImage(), movies.getBody().getImage());
    }
}
