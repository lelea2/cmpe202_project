package Parking;

import java.util.ArrayList;

/**
 * Created by kdao on 8/3/16.
 * Modified by ycheng on 8/9/16
 */

public class Parking {
    private static Parking data = null;
    private int totalSlotNumber = 10; //Hard code total number of parking slot for now
    private boolean[] parkingSlots;

    public Parking() {
        this.totalSlotNumber = totalSlotNumber;
        this.parkingSlots = new boolean[totalSlotNumber];
    }

    //To keep data maintained, synchronized
    public static synchronized Parking load() {
        if (data == null) {
            data = new Parking();
        }
        return data;
    }


    public ArrayList<Integer> getAvailableSlots() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < this.parkingSlots.length; i++){
            if (!this.parkingSlots[i]){
                arr.add(i);
            }
        }
        return arr;
    }

    public boolean enterParkingSlot(int slot) {
        if (slot < 0 || slot >= this.totalSlotNumber || this.parkingSlots[slot]){
            return false;
        }
        this.parkingSlots[slot] = true;
        return true;
    }

    public void exitParkingSlot(int slot) {
        if (slot >= 0 && slot < this.totalSlotNumber){
            this.parkingSlots[slot] = false;
        }
    }

}
