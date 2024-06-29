package diplom.task_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient mockIngredient1 = mock(Ingredient.class);
        Ingredient mockIngredient2 = mock(Ingredient.class);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(1, 0);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient.getPrice()).thenReturn(1.0f);

        burger.addIngredient(mockIngredient);
        burger.getPrice();
        assertEquals(5.0f, burger.getPrice(), 0);

    }

    @Test
    public void testGetReceipt() {

        String mockNameBun = "testNameBun";
        when(mockBun.getName()).thenReturn(mockNameBun);

        float mockNamePriceBun = 1.5f;
        when(mockBun.getPrice()).thenReturn(mockNamePriceBun);

        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);

        String mockNameIngredient = "testNameIngredient";
        when(mockIngredient.getName()).thenReturn(mockNameIngredient);

        float mockPriceIngredient = 0.5f;
        when(mockIngredient.getPrice()).thenReturn(mockPriceIngredient);

        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();
        String expectedPrice = String.format("%f", burger.getPrice()); //при вызове burger.receipt из-за String.format к ответу getPrice добавляется еще 5 знаков после запятой. Чтобы уравнять ассерты, применяем точно такое же форматирвоание

        String expectedReceipt = "(==== " + mockNameBun + " ====)\r\n" +
                "= filling " + mockNameIngredient + " =\r\n" +
                "(==== " + mockNameBun + " ====)\r\n" +
                "\r\nPrice: "+expectedPrice+"\r\n";

        assertEquals(expectedReceipt, receipt);
    }

}