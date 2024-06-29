package diplom.task_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private IngredientType ingredientType;
    private Ingredient ingredient;
    private String name = "testName";
    private float price = 3.1f;

    @Before
    public void setUp(){
        ingredientType = IngredientType.FILLING;
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void testConstructor(){
        assertEquals(ingredientType, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetType(){
        assertEquals(ingredientType, ingredient.getType());
    }

}


