package ass3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ColourTable {

    private int size;
    final private int MAX_CAPACITY;
    private final List<Color> structure;

    /**
     * create an empty Colour Table of a specific size
     *
     * @param tableSize the maximum capacity of the table. Valid table sizes are {@code {2,4,8,16,32,64,128,256,512,1024}} only.
     * @throws IllegalArgumentException if the table size given is invalid
     * **/
    public ColourTable(int tableSize) {
        //check the table size is valid
        Set<Integer> allowableTableSizes = Set.of( new Integer[] {2,4,8,16,32,64,128,256,512,1024});

        if(!allowableTableSizes.contains(tableSize)){
            throw new IllegalArgumentException();
        }

        this.MAX_CAPACITY = tableSize;
        this.structure = new ArrayList<>(tableSize);
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

    /**
     * Adds a given rgb colour to the colour table
     *
     * @param red red colour component,0-255
     * @param green blue colour component,0-255
     * @param blue blue colour component,0-255
     * @return the index at which this colour can be retrieved from in the colour table
     *
     * @throws IllegalArgumentException if the colour components are not all integers between 0-255 inclusive
     * @throws ColourTableFullException if the colour table is at capacity
    **/
    public int add(int red, int green, int blue) {
        //the inputs maybe invalid

        Color newColour;
        try {
             newColour = new Color(red, green, blue);
        }//catch and rethrow for encapsulation
        //I know its ugly but there shouldn't be more than two cases
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }catch (ColourTableFullException e){
            throw new ColourTableFullException();
        }

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

    /**
     * get the RGB colour at index i
     * @return an integer array of the red,green,blue colour components at a given index
     * @throws IndexOutOfBoundsException if an invalid index is passed i.e. negative or greater
     * than the number of elements in the colour table
     * **/
    public int[] getRGB(int i) {
        //this might be irritating, but I don't want the client to know anything
        // so if a helper function throws an exception just catch and rethrow it

        try {
            //let the simpler method do the simple stuff
            Color theColor = this.getsRGB(i);
            // get RGB parts
            int red = theColor.getRed();
            int blue = theColor.getBlue();
            int green = theColor.getGreen();
            return new int[] {red, green, blue};

        }catch (IndexOutOfBoundsException e){
            throw e;
        }
    }

    /**
     * get the sRGB colour at index i
     * @return the java.awt.Color instance at a given index
     * @throws IndexOutOfBoundsException if an invalid index is passed i.e. negative or greater
     * than the number of elements in the colour table
     * **/
    public Color getsRGB(int index) {
        try {
            //the list API throws an unchecked IndexOutOfBounds
            //which is the behaviour I want, so just rethrow it for encapsulation
            //then the client doesn't know the implementation
            return this.structure.get(index);
        }catch (IndexOutOfBoundsException e){
            throw e;
        }
    }
}
