
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

import java.util.ArrayList;


/**
 * Abstract class that is parent of HeavyContainer and BasicContainer. Has some methods and fields that are inherited .
 * @author FurkanBulbul
 */
public abstract class Container implements Comparable<Container> {
    /**
     * ID of container.
     */
    private int ID;
    /**
     * weight of container .
     */
    private int weight;
    /**
     * static count of containers.
     */
    private static int countContainer=0;
    /**
     * static list of containers.
     */
    public static ArrayList<Container> listContainers=new ArrayList<Container>();

    /**
     * constructor method of abstract Container class.
     * @param ID id of the container
     * @param weight weight of the container
     */
    public Container(int ID, int weight) {
        this.ID=ID;
        this.weight=weight;
        countContainer++;

    }
    /**
     * calculates the fuel consumption of the container.
     * @return fuel consumption  of the container per KM
     */
    public abstract double consumption();
    /**
     * checks if the other container is same with this container.
     * @param other other container compared
     * @return if containers are equals or not
     */
    public abstract  boolean equals(Container other);

    public int compareTo(Container c) {
        return this.ID-c.ID;
    }
    /**
     * getter method of ID
     * @return ID
     */
    public int getID(){
        return this.ID;
    }
    /**
     * getter method of weight
     * @return weight
     */
    public int getWeight() {
        return this.weight;
    }
    /**
     *
     * @return count of container created
     */
    public static int getCountContainer() {
        return countContainer;
    }
    //for junit
    public static void setCountContainer(int n) {
        countContainer=n;
    }







}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

