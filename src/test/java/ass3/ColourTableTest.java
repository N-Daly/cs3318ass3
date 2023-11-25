package ass3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
public class ColourTableTest {


    /**
     * not passing arguments to the constructor should give an error
     * */
    @Test
    public void addAColor() {
        Color colourBlack = Color.black;
        ColourTable table = new ColourTable(2);
        Object index = (Object) table.add(colourBlack);
        assertEquals(0, index);

    }
}
