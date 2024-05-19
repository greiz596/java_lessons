package sprint6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void testLionSexMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionSexFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionSexException() {
        assertThrows(Exception.class, () -> new Lion("Пол неизвестен", feline));
    }

    @Test
    public void testLionGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(99);
        assertEquals(99, lion.getKittens());
    }

    @Test
    public void testLionGetFoodList() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }
}