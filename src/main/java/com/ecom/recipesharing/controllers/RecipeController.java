package com.ecom.recipesharing.controllers;

import com.ecom.recipesharing.models.Recipe;
import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.services.RecipeService;
import com.ecom.recipesharing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @PostMapping("/recipe/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId){
       // User user=userService.findUserById(userId);
        Recipe createdRecipe=recipeService.createRecipe(recipe,null);
        return  createdRecipe;
    }
}
