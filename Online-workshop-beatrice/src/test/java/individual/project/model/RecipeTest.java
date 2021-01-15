package individual.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {
    @Test
    void NewOrderTest()
    {
       Recipe r = new Recipe(1, 1, "Cake HOW to", "Cacao", "Mix everything", "12/1");
        assertEquals(1, r.getId());
        assertEquals(1, r.getUserId());
        assertEquals("Cake HOW to", r.getTitle());
        assertEquals("Cacao", r.getContent());
        assertEquals("Mix everything", r.getInstructions());
        assertEquals("12/1", r.getDate());
    }
    @Test
    void setId() {
        Recipe r = new Recipe();
        r.setId(1);
        assertEquals(1, r.getId());
    }
    @Test
    void setUserId() {
        Recipe r = new Recipe();
        r.setUserId(1);
        assertEquals(1, r.getUserId());
    }
    @Test
    void setTitle() {
        Recipe r = new Recipe();
        r.setTitle("Cake HOW to");
        assertEquals("Cake HOW to", r.getTitle());
    }
    @Test
    void setContent() {
        Recipe r = new Recipe();
        r.setContent("Cacao");
        assertEquals("Cacao", r.getContent());
    }
    @Test
    void setInstructions() {
        Recipe r = new Recipe();
        r.setInstructions("Mix everything");
        assertEquals("Mix everything", r.getInstructions());
    }
    @Test
    void setDate() {
        Recipe r = new Recipe();
        r.setDate("12/1");
        assertEquals("12/1", r.getDate());
    }


}
