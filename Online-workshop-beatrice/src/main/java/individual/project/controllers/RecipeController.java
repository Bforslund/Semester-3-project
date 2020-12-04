package individual.project.controllers;
import individual.project.model.*;
import individual.project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeController {
    HibernateRecipesRepository repository = new HibernateRecipesRepository();
    public List<Recipe> showAllRecipes() {
        List<Recipe> recipes;
        try {
            recipes = repository.getRecipes();
            return recipes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean addRecipe(Recipe i) {
        try {
            repository.create(i);
            System.out.println("Created Recipe: " + i);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
