import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void SauceIsExist() {
        String expected = "SAUCE";
        assertEquals(expected, String.valueOf(IngredientType.SAUCE));
    }

    @Test
    public void FillingIsExist() {
        String expected = "FILLING";
        assertEquals(expected, String.valueOf(IngredientType.FILLING));
    }
}
