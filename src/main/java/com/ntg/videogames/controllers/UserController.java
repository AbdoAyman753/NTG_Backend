package com.ntg.videogames.controllers;

import com.ntg.videogames.entities.User;
import com.ntg.videogames.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value={"","/"})
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.fetchAll());
    }

    @PostMapping("/cart")
    public ResponseEntity<?> updateUserCart(@RequestBody User user){
//        System.out.println(user);
        Optional<User> dbUser = userService.findUser(user.getId());
        if(dbUser.isPresent()){
            dbUser.get().setCartGames(user.getCartGames());
            return ResponseEntity.ok(userService.saveUser(dbUser.get()));
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/library")
    public ResponseEntity<?> updateUserLibrary(@RequestBody User user){
//        System.out.println(user);
        Optional<User> dbUser = userService.findUser(user.getId());
        if(dbUser.isPresent()){
            System.out.println("Updating");
//            User mergedUser = userService.mergeUser(user);
            dbUser.get().setLibrary(user.getLibrary());
            return ResponseEntity.ok(userService.saveUser(dbUser.get()));
        }
        return ResponseEntity.badRequest().build();
    }
}
