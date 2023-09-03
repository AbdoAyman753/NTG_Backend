package com.ntg.videogames.services;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.entities.Game;
import com.ntg.videogames.repositories.CategoryRepository;
import com.ntg.videogames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Category> fetchAll(){
        return categoryRepository.findAll();
    }
    @Override
    public Optional<Category> saveCategory(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> findByName(String name){return categoryRepository.findByName(name);}

    @Override
    public void addCategoryToGame(String gameTitle, String categoryName) {
//        Category category = categoryRepository.findByName(categoryName);
        Game game = gameRepository.findByTitle(gameTitle);
//        game.getCategories().add(category);
    }
}
