package ass3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ColourTable {

    private int size;
    final private int MAX_CAPACITY;
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

        //if its already in the table then it has an index and just return that
        int indexOfColour = this.findIndexOf(colour);
        if(indexOfColour != -1){return indexOfColour;}

        if (this.size >= this.MAX_CAPACITY){throw new ColourTableFullException();}

        int index = this.size;
        //this is unnecessary but explicit
        this.structure.add(index, colour);
        this.size ++;
        return index;
    }

    public int add(int red, int green, int blue) {
        Color newColour = new Color(red,green,blue);
        //do as little work possible
        return this.add(newColour);
    }

    /**
     * @return the index of the colour argument as the client would see it, or -1
     * **/
    private int findIndexOf(Color targetColour){
        for (int i = 0; i < this.size; i++) {
            Color element = this.structure.get(i);
            if (element.equals(targetColour)){
                return i;
            }
        }
        return -1;
    }

    private boolean checkValidIndex(int index){
        if (index <0 | index > this.size){return false;}
        return true;
    }
    public int[] getRGB(int i) {
        if (!checkValidIndex(i)){throw new IndexOutOfBoundsException();}
        //the index must be valid
        Color theColor = this.structure.get(i);
        // get RGB parts
        int red = theColor.getRed();
        int blue = theColor.getBlue();
        int green = theColor.getGreen();
        return new int[] {red, green, blue};
    }

    public Color getsRGB(int index) {
        if (!checkValidIndex(index)){throw new IndexOutOfBoundsException();}
        //the index must be valid
        Color theColor = this.structure.get(index);
        return  theColor;
    }
}
