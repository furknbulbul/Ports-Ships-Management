
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * this class extends abstract Container class and has operations of a basic container.
 * @author FurkanBulbul
 *
 */
public class BasicContainer extends Container {
    /**
     * Constructor method
     */
    public BasicContainer(int ID,int weight) {
        super(ID,weight);
    }
    /**
     * {@inheritDoc}
     * @return fuel consumption of the basic container in this implementation
     */
    public double consumption() {
        return this.getWeight()*2.50;
    }
    /**
     * {@inheritDoc}
     * In this implementation checks for type BasicContainer
     */
    public boolean equals(Container other) {
        if(other.getClass()==BasicContainer.class) {

            return this.getID()==other.getID() && this.getWeight() == other.getWeight();
        }else{
            return false;
        }

    }



}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

