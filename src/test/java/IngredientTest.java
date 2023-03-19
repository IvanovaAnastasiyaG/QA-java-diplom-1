import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredients. Test data: {0} {1}")
    public static Object[][] getIngredientTest(){
        return new Object[][]{
                {IngredientType.SAUCE,"Chili",11f},
                {IngredientType.FILLING,"Salad",1.05f},
                {IngredientType.SAUCE,"Кунжутное",0f},
                {IngredientType.FILLING,"$Salad$",11.59f},
                {IngredientType.SAUCE,"'Кунжутное'",678.0004f},
                {IngredientType.FILLING,"Томат",0.0000000001f},
                {IngredientType.SAUCE,"barbecue sause barbecue sause barbecue sause",3.4e+038f},
                {IngredientType.FILLING,"fried bacon fried bacon fried bacon",101.7f},
                {IngredientType.SAUCE,"",500f},
                {IngredientType.FILLING,"",5000000f},
                {IngredientType.SAUCE,null,-5f},
                {IngredientType.FILLING, null,-0.000f},
        };
    }

    @Test
    public void getValueIngredient() {
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price,ingredient.getPrice(), 0);
    }

    @Test
    public void constructorIngredientLinkIngredient() {
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(type, ingredient.type);
        assertEquals(name, ingredient.name);
        assertEquals(price, ingredient.price,0);
    }
}
