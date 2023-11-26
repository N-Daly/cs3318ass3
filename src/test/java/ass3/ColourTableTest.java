package ass3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest()
    @ValueSource(ints = {0,1,3,5,7,9,15,17,33,63,65,127,129,250,1025})
    public void badInputsToConstructor(int invalidPaletteSize){
        boolean exceptionThrown = false;
        try{
            ColourTable table  = new ColourTable(invalidPaletteSize);
        }catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @ParameterizedTest()
    @ValueSource(ints = {2,4,8,16,32,64,128,256,512,1024})
    public void validInputsToConstructor(int tableSize) {
        //make a table
        ColourTable table = new ColourTable(tableSize);

        //add a colour
        Color colourBlack = Color.black;
        int index = table.add(colourBlack);
        assertEquals(0, index);

    }

    @Test
    public void exceedCapacityOfTableSize8(){
        ColourTable table = new ColourTable(8);

        Color[] colours = {Color.black,Color.blue,Color.cyan,Color.darkGray,
                            Color.gray,Color.yellow,Color.orange,Color.green};
        for(Color col: colours){
            table.add(col);
        }

        boolean exceptionThrown = false;
        try{
            //this should give an exception
            table.add(Color.magenta);
        }catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

    }
}
