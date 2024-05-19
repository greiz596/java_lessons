package sprint6;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FelineTest {

    @Test
    public void testFelineGetFoodException()  {
        Feline feline = new Feline();
        assertThrows(Exception.class, () -> feline.getFood("Летающее"));
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testFelineGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(1));
        assertEquals(1, feline.getKittens());
    }
}