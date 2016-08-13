package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public interface VehicleState {
    void free();

    void schedule();

    void operate();

    void finish();
}