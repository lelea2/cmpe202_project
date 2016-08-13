package Vehicle;

/**
 * Created by kdao on 8/13/16.
 */
public interface VehicleState {
    boolean isAvailable();

    boolean isScheduled();

    boolean isOperating();
}