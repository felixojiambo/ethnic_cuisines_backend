package com.ecom.recipesharing.controllers;
import com.ecom.recipesharing.models.Recipe;
import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.services.RecipeService;
import com.ecom.recipesharing.services.UserService;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @PostMapping("")
    public Recipe createRecipe(@RequestBody Recipe recipe, @RequestHeader("Authorization") String jwt) throws Exception {
       User user=userService.findUserByJwt(jwt);
        return recipeService.createRecipe(recipe,null);
    }
    @GetMapping("/get-all")
    public List<Recipe> getAllRecipe() throws Exception {
        return recipeService.findAllRecipe();
    }
    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {
        return recipeService.updateRecipe(recipe,id);
    }
    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {
        recipeService.deleteRecipe(recipeId);
        return "Recipe delete successfully";
    }
    @PutMapping("/{id}/like")
    public Recipe likeRecipe( @RequestHeader("Authorization")String jwt,@PathVariable Long id) throws Exception {
        User user=userService.findUserByJwt(jwt);
        return recipeService.likeRecipe(id,user);
    }
}
