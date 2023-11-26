package ass3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
public class ColourTableTest {

    @Test
    public void addAColor() {
        Color colourBlack = Color.black;
        ColourTable table = new ColourTable(2);
        Object index = (Object) table.add(colourBlack);
        assertEquals(0, index);

    }

    @Test
    public void testNoArgConstructor(){
        Executable executable = () -> {
            //should give an exception
            ColourTable t = new ColourTable();
        };
        assertThrows(Exception.class, executable);
    }
}
