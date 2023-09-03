package com.ntg.videogames.services;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.entities.Game;
import com.ntg.videogames.repositories.CategoryRepository;
import com.ntg.videogames.repositories.GameRepository;
import com.ntg.videogames.utils.GameQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Set<Game> fetchGames(Map<String, String> params) {
        if(params.containsKey("categories")){
            String[] categories = params.get("categories").split(",");
            List<Category> categoryIds = new ArrayList<>();
            for (String category: categories) {
                Category temp = new Category();
                temp.setId(Long.parseLong(category));
                categoryIds.add(temp);
            }
            return gameRepository.findByPriceBetweenAndCategoriesIn(
                    Double.parseDouble(params.get("minPrice")),
                    Double.parseDouble(params.get("maxPrice")),
                    categoryIds);
        }
        return gameRepository.findByPriceBetween(Double.parseDouble(params.get("minPrice")),
                Double.parseDouble(params.get("maxPrice")));
    }
    @Override
    public List<Game> fetchAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game fetchById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("****** [Game Service]: Nothing To Show. ******");
        }
        return game.get();
    }

    @Override
    public Game save(Game game) {
//        Game gameToSave = Game.builder()
//                .title(game.getTitle())
//                .description(game.getDescription())
//                .price(game.getPrice())
//                .coverImage(game.getCoverImage())
//                .releaseDate(game.getReleaseDate())
//                .build();
//        gameToSave = gameRepository.save(gameToSave);
//        if(!game.getCategories().isEmpty()){
//            for (Category category: game.getCategories()) {
//                Category currCat = categoryRepository.save(category);
//                gameToSave.getCategories().add(currCat);
//            }
//        }
//        return gameToSave;
        return gameRepository.save(game);
    }
}
