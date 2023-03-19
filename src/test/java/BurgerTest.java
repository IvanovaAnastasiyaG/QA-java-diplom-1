import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsIsBurgerBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientIsExistInBurger() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals(List.of(ingredient1), burger.ingredients);
    }

    @Test
    public void removeIngredientIsNotExistInBurger() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.removeIngredient(0);
        assertEquals(List.of(ingredient2), burger.ingredients);
    }

    @Test
    public void moveIngredientChangePositionIngredientInBurger() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceReturnSumPriceBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(11f);
        Mockito.when(ingredient1.getPrice()).thenReturn(48f);
        float expectedPrice = 11f + 48f + 11f;
        assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptPrintReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getName()).thenReturn("wheat");
        Mockito.when(bun.getPrice()).thenReturn(8f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        Mockito.when(ingredient1.getPrice()).thenReturn(33f);
        assertEquals(String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice()),
                            burger.getReceipt()
        );
    }
}


