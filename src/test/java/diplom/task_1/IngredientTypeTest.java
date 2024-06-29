package diplom.task_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    private IngredientType i;

    @Test
    public void testIngredientTypeNotNullValues() {
        for (IngredientType t : IngredientType.values()) {
            assertNotNull(t);
        }
    }

    @Test
    public void testIngredientTypeValuesOf() {
        for (IngredientType t : IngredientType.values()) {
            assertEquals(t, IngredientType.valueOf(t.name()));
        }
    }
}
