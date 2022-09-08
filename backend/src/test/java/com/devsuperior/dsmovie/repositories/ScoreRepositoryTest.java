package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.domain.Score;
import com.devsuperior.dsmovie.util.ScoreCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Score Repository")
public class ScoreRepositoryTest {

    @Autowired
    ScoreRepository scoreRepository;

    @Test
    @DisplayName("Save persists score when Sucessful")
    void save_PersistUser_WhenSucessful() {

        Score scoreToBeSaved = ScoreCreator.scoreCreator();
 
        Score scoreSaved = this.scoreRepository.save(scoreToBeSaved);

        Assertions.assertNotNull(scoreSaved);
        Assertions.assertNotNull(scoreSaved.getId());
        Assertions.assertEquals(scoreSaved.getValue(), scoreToBeSaved.getValue());
        Assertions.assertTrue(scoreSaved.getValue() >= 1.0);
    }
}
