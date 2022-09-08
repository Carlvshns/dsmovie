package com.devsuperior.dsmovie.util;

import com.devsuperior.dsmovie.domain.Score;
import com.devsuperior.dsmovie.domain.ScorePK;

public class ScoreCreator {
    
    public static Score scoreCreator() {

        Score score = new Score();
        score.setId(new ScorePK());
        score.setMovie(MovieCreator.movieCreator());
        score.setUser(UserCreator.userCreator());
        score.setValue(4.5);

        return score;
    }
}
