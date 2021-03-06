/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweas;

/**
 *
 * @author ma2-le
 */
public class Room {
    private Lease lease;
    private int roomNumber;
    private int cleaningStatus; //1-Clean, 2-Dirty, 3-Offline
    private int monthlyRate;
    private boolean isOccupied;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(int roomNumber, int cleaningStatus, int monthlyRate, boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.cleaningStatus = cleaningStatus;
        this.monthlyRate = monthlyRate;
        this.lease = null; //The room has no lease initially
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public int getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(int cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public int getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(int monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public boolean isOccupied()
    {
        // Return whether occupied based on lease
        // Return boolean based on whether occupied or not
        return !(getLease() == null);
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    
}
