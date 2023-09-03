package com.ntg.videogames.services;

import com.ntg.videogames.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> fetchAll();

    Optional<User> findUser(Long id);

    User findUserByEmail(String email);
}
