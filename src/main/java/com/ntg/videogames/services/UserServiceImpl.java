package com.ntg.videogames.services;

import com.ntg.videogames.entities.User;
import com.ntg.videogames.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Override
    public List<User> fetchAll(){
        return userRepository.findAll();
    }
    @Override
    public Optional<User> findUser(Long id){
        return userRepository.findById(id);
    }
    @Override
    public User findUserByEmail(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        return null;
    }

    public User mergeUser(User user) {
        return entityManager.merge(user);
    }
}
