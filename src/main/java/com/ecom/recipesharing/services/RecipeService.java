package com.ecom.recipesharing.services;

import com.ecom.recipesharing.models.Recipe;
import com.ecom.recipesharing.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    public Recipe createRecipe(Recipe recipe, User user);
    public Recipe findRecipeById(Long id) throws  Exception;
    public  void deleteRecipe(Long id)throws  Exception;
    public  Recipe updateRecipe(Recipe recipe,Long id)throws Exception;
    public List<Recipe> findAllRecipe();
    public  Recipe likeRecipe(Long recipe,User user) throws Exception;
}
