package com.devsuperior.dsmovie.services;

import java.util.Optional;

import com.devsuperior.dsmovie.domain.Movie;
import com.devsuperior.dsmovie.domain.Score;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.util.MovieCreator;
import com.devsuperior.dsmovie.util.ScoreCreator;
import com.devsuperior.dsmovie.util.UserCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTest {

    @InjectMocks
    private ScoreService scoreService;

    @Mock
    private ScoreRepository scoreRepositoryMock;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private MovieRepository movieRepositoryMock;

    @BeforeEach
    void setUp(){

        BDDMockito.when(scoreRepositoryMock.saveAndFlush(ArgumentMatchers.any(Score.class)))
        .thenReturn(ScoreCreator.scoreCreator());

        BDDMockito.when(userRepositoryMock.findById(ArgumentMatchers.anyLong()))
        .thenReturn(Optional.of(UserCreator.userCreator()));

        BDDMockito.when(movieRepositoryMock.findById(ArgumentMatchers.anyLong()))
        .thenReturn(Optional.of(MovieCreator.movieCreator()));

        BDDMockito.when(movieRepositoryMock.save(ArgumentMatchers.any(Movie.class)))
        .thenReturn(MovieCreator.movieCreator());
    }

    @Test
    @DisplayName("save returns movie when sucessful")
    void save_ReturnsMovie_WhenSucessful() {

        ScoreDTO expectedScore = ScoreCreator.scoreDTOCreator();

        MovieDTO movie = scoreService.saveScore(ScoreCreator.scoreDTOCreator());

        Assertions.assertNotNull(movie);
        Assertions.assertEquals(expectedScore.getMovieId(), movie.getId());
        Assertions.assertEquals(expectedScore.getScore(), movie.getScore());
    }
}
