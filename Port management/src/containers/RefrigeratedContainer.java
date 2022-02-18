
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * this class extends HeavyContainer lass and has operations of a refrigerated container.
 * @author FurkanBulbul
 *
 */

public final class RefrigeratedContainer extends HeavyContainer {
    public RefrigeratedContainer(int ID, int weight) {
        super(ID,weight);
    }
    /**
     * {@inheritDoc}
     * @return fuel consumption of the liquid heavy container in this implementation.
     */
    public  double  consumption() {
        return this.getWeight()*5.00;
    }
    /**
     * {@inheritDoc}
     * in this implementation checks for type RefrigeratedContainer
     */
    public boolean equals(Container other) {
        if(other.getClass()==RefrigeratedContainer.class) {
            return this.getID()==other.getID() && this.getWeight() == other.getWeight();
        }else{
            return false;
        }

    }

}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

