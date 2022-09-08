package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.domain.User;
import com.devsuperior.dsmovie.util.UserCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for User Repository")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("FindByNameIgnoringCase returns list page of Movies when Sucessful")
    void findByNameIgnoringCase_ReturnsPageOfMovies_WhenSucessful() {

        User userToBeSaved = UserCreator.userCreator();

        User userSaved = this.userRepository.save(userToBeSaved);

        User  user = this.userRepository.findByEmail(userSaved.getEmail());

        Assertions.assertNotNull(user);
        Assertions.assertEquals(userSaved.getEmail(), user.getEmail());
        Assertions.assertEquals(userSaved.getId(), user.getId());
    }

    @Test
    @DisplayName("Save persists user when Sucessful")
    void save_PersistUser_WhenSucessful() {

        User userToBeSaved = UserCreator.userCreator();

        User userSaved = this.userRepository.save(userToBeSaved);

        Assertions.assertNotNull(userSaved);
        Assertions.assertNotNull(userSaved.getId());
        Assertions.assertEquals(userSaved.getEmail(), userToBeSaved.getEmail());
        Assertions.assertEquals(userSaved.getId(), userToBeSaved.getId());
    }
}
