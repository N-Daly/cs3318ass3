package ass3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class ColourTable {

    private int size;
    private List<Color> structure;

    public ColourTable(int i) {
        this.structure = new ArrayList<Color>(i);
        this.size = 0;
    }


    public int add(Color colour) {
        int index = this.size;
        //this is unnecessary but explicit
        this.structure.add(index, colour);
        this.size ++;
        return index;
    }
}
