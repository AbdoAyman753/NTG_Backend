package com.ntg.videogames.controllers;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.entities.Game;
import com.ntg.videogames.repositories.CategoryRepository;
import com.ntg.videogames.services.CategoryService;
import com.ntg.videogames.services.GameService;
import com.ntg.videogames.utils.GameQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<Set<Game>> fetchGames(@RequestParam Map<String, String> params){
        return ResponseEntity.ok().body(gameService.fetchGames(params));
    }
    @GetMapping("/{id}")
    public Game fetchGameById(@PathVariable("id") Long id){
        return gameService.fetchById(id);
    }
    @PostMapping(value = {"","/"})
//    @PostMapping("/games")
//    public ResponseEntity<Game> saveGame(@RequestBody Game game){
//        Set<Category> categorySet = new HashSet<>();
//        Iterator<Category> gameIterator=  game.getCategories().iterator();
//        while(gameIterator.hasNext()){
//            Optional<Category> optCat = categoryRepository.findByName(gameIterator.next().getName());
//            if(optCat.isPresent()){
//               categorySet.add(optCat.get());
//               continue;
//            }
//            Category c = new Category();
//            Category currCat = gameIterator.next();
//            c.setName(currCat.getName());
//            categorySet.add(c);
//        }
//        List<Category> catList =  categoryRepository.saveAll(categorySet);
//        Set<Category> catSet = new HashSet<>();
//        for (Category cat:catList) {
//            catSet.add(cat);
//        }
//        Game game1 = new Game();
//        game1.setTitle(game.getTitle());
//        game1.setDescription(game.getDescription());
//        game1.setPrice(game.getPrice());
//        game1.setCoverImage(game.getCoverImage());
//        game1.setReleaseDate(game.getReleaseDate());
//        game1.setCategories(catSet);
//        return  ResponseEntity.ok(gameService.save(game1));
//
//    }
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Set<Category> categorySet = new HashSet<>();
        Iterator<Category> gameIterator=  game.getCategories().iterator();
        Category currCat;
        while(gameIterator.hasNext()){
            currCat = gameIterator.next();
            Optional<Category> optCat = categoryService.findByName(currCat.getName());
            if(optCat.isPresent()){
                categorySet.add(optCat.get());
                continue;
            }
            optCat = categoryService.saveCategory(currCat);
            optCat.ifPresent(categorySet::add);
        }
        game.setCategories(categorySet);
        return  ResponseEntity.ok(gameService.save(game));

    }
}
