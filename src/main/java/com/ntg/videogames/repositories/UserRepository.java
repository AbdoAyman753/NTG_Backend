package com.ntg.videogames.repositories;

import com.ntg.videogames.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByUserName(String userName);
    public Optional<User> findByEmail(String email);

}
