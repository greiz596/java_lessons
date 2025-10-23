package diplom.task_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class GetReceiptTestParam {
    @Mock
    private Bun bun;
    private List<Ingredient> ingredients;
    private String expectedReceipt;
    private Burger burger;
    private Object object= null;

    public GetReceiptTestParam(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        String mockNameBun = "bun1";

        Bun mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn(mockNameBun);

        float mockPriceBun = 2.0f;
        when(mockBun.getPrice()).thenReturn(mockPriceBun);

        String mockNameIngredient1 = "testNameIngredient1";
        Ingredient mockIngredient1 = mock(Ingredient.class);
        when(mockIngredient1.getName()).thenReturn(mockNameIngredient1);

        float mockPriceIngredient1 = .0f;
        when(mockIngredient1.getPrice()).thenReturn(mockPriceIngredient1);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        String mockNameIngredient2 = "testNameIngredient2";
        Ingredient mockIngredient2 = mock(Ingredient.class);
        when(mockIngredient2.getName()).thenReturn(mockNameIngredient2);

        float mockPriceIngredient2 = 2.0f;
        when(mockIngredient2.getPrice()).thenReturn(mockPriceIngredient2);
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);

        String expectedPrice1 = String.format("%f", mockPriceBun*2 + mockPriceIngredient1);
        String expectedReceipt1 = String.format("(==== " + mockNameBun + " ====)%n= filling " + mockNameIngredient1 + " =%n(==== " + mockNameBun + " ====)%n%nPrice: " + expectedPrice1 + "%n");

        String expectedPrice2 = String.format("%f", mockPriceBun*2 + mockPriceIngredient1 + mockPriceIngredient2);
        String expectedReceipt2 = String.format("(==== " + mockNameBun + " ====)%n= filling " + mockNameIngredient1 + " =%n= sauce "+ mockNameIngredient2 +" =%n(==== " + mockNameBun + " ====)%n%nPrice: " + expectedPrice2 + "%n");

        String expectedPrice3 = String.format("%f", mockPriceBun*2);
        String expectedReceipt3 = String.format("(==== " + mockNameBun + " ====)%n(==== " + mockNameBun + " ====)%n%nPrice: " + expectedPrice3 + "%n");

        return Arrays.asList(new Object[][]{
                {mockBun, Arrays.asList(mockIngredient1), expectedReceipt1},
                {mockBun, Arrays.asList(mockIngredient1, mockIngredient2), expectedReceipt2},
                {mockBun, Collections.emptyList(), expectedReceipt3},
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void getReceiptTest() {

            for (Ingredient ingredient : ingredients) {
                burger.addIngredient(ingredient);
            }

        String result = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, result);
    }
}