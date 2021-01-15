package individual.project.controllers;

import individual.project.model.Recipe;
import individual.project.repository.HibernateRecipesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {
    @InjectMocks
    RecipeController controller;

    @Mock
    HibernateRecipesRepository repository;
    @Test
    public void getAllRecipes() throws Exception {
        List<Recipe> expectedRecipes = Arrays.asList(
                new Recipe(),
                new Recipe(),
                new Recipe()
        );

        when(repository.getRecipes()).thenReturn(
                Arrays.asList(
                        new Recipe(),
                        new Recipe(),
                        new Recipe()
                )
        );

        List<Recipe> actualRecipes = controller.showAllRecipes();

        assertEquals(expectedRecipes.size(), actualRecipes.size());
    }
    @Test
    public void createRecipe() throws Exception {
       Recipe r = new Recipe(1,1,"title","content", "instructions", "today");
        when(repository.create(r)).thenReturn(true);

        boolean result = controller.addRecipe(r);

        assertEquals(true, result);
    }
}
