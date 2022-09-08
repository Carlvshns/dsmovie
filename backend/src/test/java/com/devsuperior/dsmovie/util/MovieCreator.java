package com.devsuperior.dsmovie.util;

import com.devsuperior.dsmovie.domain.Movie;
import com.devsuperior.dsmovie.dto.MovieDTO;

public class MovieCreator {
    
    public static Movie movieCreator(){
        
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("The Witcher");
        movie.setScore(4.5);
        movie.setCount(2);
        movie.setImage("https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg");
        return movie;
    }

    public static MovieDTO movieDTOCreator(){
        
        MovieDTO movie = new MovieDTO();
        movie.setId(1L);
        movie.setTitle("The Witcher");
        movie.setScore(4.5);
        movie.setCount(2);
        movie.setImage("https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg");
        return movie;
    }
}
