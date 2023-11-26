package ass3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ColourTable {

    private int size;
    private int MAX_CAPACITY;
    private List<Color> structure;

    public ColourTable(int tableSize) {
        //check the table size is valid
        Set<Integer> allowableTableSizes = Set.of( new Integer[] {2,4,8,16,32,64,128,256,512,1024});

        if(!allowableTableSizes.contains(tableSize)){
            throw new IllegalArgumentException();
        }

        this.MAX_CAPACITY = tableSize;
        this.structure = new ArrayList<Color>(tableSize);
        this.size = 0;
    }

    public ColourTable(){
        throw new IllegalArgumentException();
    }


    public int add(Color colour) {

        if (this.size >= this.MAX_CAPACITY){throw new ColourTableFullException();}

        int index = this.size;
        //this is unnecessary but explicit
        this.structure.add(index, colour);
        this.size ++;
        return index;
    }
}
