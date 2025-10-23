package sprint6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestParam {
    private final List<String> foodList;
    private final String typeAnimal;

    public FelineTestParam(List<String> foodList, String typeAnimal){
        this.foodList = foodList;
        this.typeAnimal = typeAnimal;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Arrays.asList("Животные", "Птицы", "Рыба"), "Хищник"},
                {Arrays.asList("Трава", "Различные растения"), "Травоядное"}
        });
    }

    @Test
    public void testFelineGetFoodList() throws Exception {
        Feline feline = new Feline();
        assertEquals(foodList, feline.getFood(typeAnimal));
    }
}