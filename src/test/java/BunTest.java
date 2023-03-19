import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters (name = "Bun. Test data: {0} {1}")
    public static Object[][] getBunTest() {
        return new Object[][]{
                {"Black",11f},
                {"Пшеничная",1.5f},
                {"bun with bran",0f},
                {"bun with bran bun with bran bun with bran",0.0000000001f},
                {"white's bun $",3.4e+038f},
                {"",101.7f},
                {"bun with bran",500f},
                {null, -5f}
        };
    }

    @Test
    public void constructorBunLinkBun() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.name);
        assertEquals(price, bun.price,0);
    }

    @Test
    public void getValueBun() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(),0);
    }
}
