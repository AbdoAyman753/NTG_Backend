package com.ntg.videogames.repositories;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String title);

    Set<Game> findByPriceBetweenAndCategoriesIn(Double minPrice, Double maxPrice, List<Category> categoryIds);
    Set<Game> findByPriceBetween(Double minPrice, Double maxPrice);
}
