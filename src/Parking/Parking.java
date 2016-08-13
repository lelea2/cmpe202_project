package Parking;

import java.util.ArrayList;

/**
 * Created by kdao on 8/3/16.
 * Modified by ycheng on 8/9/16
 */

public class Parking {

    private int totalSlotNumber;
    private int availableSlotNumber;
    private boolean[] parkingSlots;


    public Parking(int totalSlotNumber) {
        this.totalSlotNumber = totalSlotNumber;
        this.parkingSlots = new boolean[totalSlotNumber];
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

    public int getAvailableSlotNumber() {
        return this.availableSlotNumber;
    }

    public boolean enterParkingSlot(int slot){
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
