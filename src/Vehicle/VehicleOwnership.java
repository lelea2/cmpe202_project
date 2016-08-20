package Vehicle;

/**
 * Created by kdao on 7/22/16.
 */
public abstract class VehicleOwnership {
    protected String ownerName;

    public VehicleOwnership(String name) {
        ownerName = name;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
