package com.ntg.videogames.services;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.entities.Game;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> fetchAll();

    Optional<Category> saveCategory(Category category);

    Optional<Category> findByName(String name);

    void addCategoryToGame(String gameTitle, String categoryName);
}
