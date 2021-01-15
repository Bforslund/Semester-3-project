package individual.project.resources;

import individual.project.controllers.OrderController;
import individual.project.controllers.RecipeController;
import individual.project.model.Order;
import individual.project.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeResourcesTest {
    @InjectMocks
    RecipeResources resources;

    @Mock
    RecipeController controller;
    @Test
    public void getAllRecipes()  {
        when(controller.showAllRecipes()).thenReturn(
                Arrays.asList(
                        new Recipe()
                )
        );

        Response response = resources.getAllRecipes();

        Assertions.assertEquals(response.getStatus(), 200);
    }
    @Test
    public void createRecipe() {
        Recipe o = new Recipe();
        when(controller.addRecipe(o)).thenReturn(true);

        Response response = resources.createRecipe(o);

        assertEquals(response.getStatus(), 201);
    }
}
