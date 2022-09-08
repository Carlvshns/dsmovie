package com.devsuperior.dsmovie.util;

import com.devsuperior.dsmovie.domain.Score;
import com.devsuperior.dsmovie.domain.ScorePK;
import com.devsuperior.dsmovie.dto.ScoreDTO;

public class ScoreCreator {
    
    public static Score scoreCreator() {

        Score score = new Score();
        score.setId(new ScorePK());
        score.setMovie(MovieCreator.movieCreator());
        score.setUser(UserCreator.userCreator());
        score.setValue(4.5);

        return score;
    }

    public static ScoreDTO scoreDTOCreator() {

        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setMovieId(MovieCreator.movieCreator().getId());
        scoreDTO.setEmail(UserCreator.userCreator().getEmail());
        scoreDTO.setScore(scoreCreator().getValue());

        return scoreDTO;
    }
}
