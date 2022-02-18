
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;



/**
 * this class extends abstract Container class and has operations of a heavy container.
 * @author FurkanBulbul
 */
public class HeavyContainer extends Container{

    /**
     * constructor method of HeavyContainer class
     * @param ID id of the heavy container
     * @param weight weight of the heavy container
     */
    public HeavyContainer(int ID, int weight) {
        super(ID,weight);
    }
    /**
     * {@inheritDoc}
     * @return fuel consumption of the heavy container in this implementation
     */
    public double consumption(){
        return this.getWeight()*3.00;
    }
    /**
     * {@inheritDoc}
     * in this implementation checks for type HeavyContainer
     */
    public boolean equals(Container other) {
        if(HeavyContainer.class ==other.getClass() ) {
            return this.getID()==other.getID() && this.getWeight() == other.getWeight();
        }else{
            return false;
        }
    }
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

