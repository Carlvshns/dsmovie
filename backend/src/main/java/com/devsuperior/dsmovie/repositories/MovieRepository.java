package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.domain.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
