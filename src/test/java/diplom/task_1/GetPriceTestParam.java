package diplom.task_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class GetPriceTestParam {
    Bun bun;
    Ingredient ingredient;
    Burger burger;
    private final float bunPrice;
    private final float ingredientPrice;
    private final int ingredientAmount;

    public GetPriceTestParam(float bunPrice, float ingredientPrice, int ingredientAmount) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientAmount = ingredientAmount;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bun = mock(Bun.class);
        ingredient = mock(Ingredient.class);
        burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] price() {
        return new Object[][]{{0.21f, 0.0f, 0}, {0.0f, 0.0f, 2}, {15231.312390f, 0.0f, 0},};
    }

    @Test
    public void getPriceTest() {
        float price = (bunPrice * 2) + (ingredientPrice * ingredientAmount);
        burger.setBuns(bun);
        for (int i = 1; i <= ingredientAmount; i++) {
            burger.addIngredient(ingredient);
        }
        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);
        float result = burger.getPrice();
        Assert.assertEquals(price, result, 0);
    }
}