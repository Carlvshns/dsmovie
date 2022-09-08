package com.devsuperior.dsmovie.util;

import com.devsuperior.dsmovie.domain.Movie;

public class MovieCreator {
    
    public static Movie movieCreator(){
        
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("The Witcher");
        movie.setScore(4.5);
        movie.setCount(2);
        movie.setImage("https://image");
        return movie;
    }
}
