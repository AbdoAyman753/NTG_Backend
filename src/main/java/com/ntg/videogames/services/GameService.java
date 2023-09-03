package com.ntg.videogames.services;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.entities.Game;
import com.ntg.videogames.utils.GameQueryParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GameService {
    List<Game> fetchAll();

    Game fetchById(Long id);

    Game save(Game game);

    Set<Game> fetchGames(Map<String, String> params);
}
