package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.domain.Score;
import com.devsuperior.dsmovie.domain.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
