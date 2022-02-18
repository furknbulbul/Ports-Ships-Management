
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

/**
 * this class extends the HeavyContainer class and has operations of a liquid container.
 * @author FurkanBulbul
 *
 */

public final class LiquidContainer extends HeavyContainer {
    /**
     * constructor method of LiquidContainer class
     * @param ID id of the liquid container
     * @param weight weight of the liquid container
     */
    public LiquidContainer(int ID, int weight) {
        super(ID,weight);
    }
    /**
     * {@inheritDoc}
     * @return fuel consumption of the liquid heavy container in this implementation
     */
    public double consumption() {
        return this.getWeight()*4.00;

    }
    /**
     * {@inheritDoc}
     * in this implementation checks for type LiquidContainer
     */
    public boolean equals(Container other) {
        if(other.getClass()==LiquidContainer.class) {
            return this.getID()==other.getID() && this.getWeight() == other.getWeight();
        }else{
            return false;
        }

    }


}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

