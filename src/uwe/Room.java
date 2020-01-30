package uwe;

public class Room {
    private Lease lease;
    private int roomNumber;
    private int cleaningStatus;
    private int montlyRate;
    private boolean isOccupied;

    public Room(Lease lease, int roomNumber, int cleaningStatus, int montlyRate, boolean isOccupied) {
        this.lease = lease;
        this.roomNumber = roomNumber;
        this.cleaningStatus = cleaningStatus;
        this.montlyRate = montlyRate;
        this.isOccupied = isOccupied;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(int cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public int getMontlyRate() {
        return montlyRate;
    }

    public void setMontlyRate(int montlyRate) {
        this.montlyRate = montlyRate;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
