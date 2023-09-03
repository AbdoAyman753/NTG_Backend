package com.ntg.videogames.controllers;

import com.ntg.videogames.entities.Category;
import com.ntg.videogames.services.CategoryService;
import com.ntg.videogames.utils.CategoryToGameReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = {"","/"})
    public ResponseEntity<List<Category>> fetchCategories(){
        return ResponseEntity.ok(categoryService.fetchAll());
    }
    @PostMapping(value = {"","/"})
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category).get();
    }

    @PostMapping(value = {"/addtogame"})
    public ResponseEntity<?> addCategoryToGame(@RequestBody CategoryToGameReq req){
        categoryService.addCategoryToGame(req.getGameTitle(), req.getCategoryName());
        return ResponseEntity.ok().build();
    }
}
