package com.devsuperior.dsmovie.util;

import com.devsuperior.dsmovie.domain.User;

public class UserCreator {
    
    public static User userCreator() {
        
        User user = new User();
        user.setId(1L);
        user.setEmail("maria@gmail.com");
        return user;
    }
}
