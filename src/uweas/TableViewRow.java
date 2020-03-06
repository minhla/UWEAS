/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweas;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ma2-le
 */
public class TableViewRow {

    private  SimpleStringProperty leaseNumber;
    private  SimpleStringProperty hallName;
    private  SimpleStringProperty roomNumber;
    private  SimpleStringProperty studentName;
    private  SimpleStringProperty occupancyStatusStr;
    private  SimpleStringProperty cleaningStatus;
    private  SimpleStringProperty leaseDuration;
    private  SimpleStringProperty hallID;
    private  SimpleStringProperty hallAdress;
    private  SimpleStringProperty hallPhoneNumber;
    private  SimpleStringProperty studentID;
    private  SimpleStringProperty monthlyRent;
    private boolean occupancyStatus;
    private Room room;
    private Lease lease;
    private Student student;
    private Hall hall;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
    
    

    
    
    public String getMonthlyRent() {
        return monthlyRent.get();
    }

    public void setMonthlyRent(String rent) {
        this.monthlyRent.set(rent);
    }

    public TableViewRow(
            String hallName,
            String hallAddress,
            String hallID,
            String hallPhone,
            String roomNumber,
            boolean occupancyStatusBool,
            String occupancyStatus,
            String cleaningStatus,
            String monthlyRent,
            String leaseNumber,
            String leaseDuration,
            String studentID,
            String studentName,
            Hall hall,
            Room room
            
    ) {

        this.hallName = new SimpleStringProperty(hallName);
        this.hallID = new SimpleStringProperty(hallID);
        this.hallPhoneNumber = new SimpleStringProperty(hallPhone);
        this.hallAdress = new SimpleStringProperty(hallAddress);
        this.leaseNumber = new SimpleStringProperty(leaseNumber);
        this.leaseDuration = new SimpleStringProperty(leaseDuration);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.studentID = new SimpleStringProperty(studentID);
        this.studentName = new SimpleStringProperty(studentName);
        this.monthlyRent = new SimpleStringProperty(monthlyRent);
        this.occupancyStatusStr = new SimpleStringProperty(occupancyStatus);
        this.occupancyStatus = occupancyStatusBool;
        this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
        this.hall = hall;
        this.room = room;
        this.lease = null;
    }

    public String getOccupancyStatus() {
        return occupancyStatusStr.get();
    }

    public void setOccupancyStatus(String occupancy) {
        this.occupancyStatusStr.set(occupancy);
    }

    public boolean isOccupied() {
        return occupancyStatus;
    }

    public void setIsOccupied(boolean occupancyStatus) {
        this.occupancyStatus = occupancyStatus;
    }

    public String getLeaseNumber() {
        return leaseNumber.get();
    }

    public void setLeaseNumber(String leaseNum) {
        this.leaseNumber.set(leaseNum);
    }

    public String getHallName() {
        return hallName.get();
    }

    public String getRoomNumber() {
        return roomNumber.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getCleaningStatus() {
        return cleaningStatus.get();
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus.set(cleaningStatus);
    }

    public String getLeaseDuration() {
        return leaseDuration.get();
    }

    public void setLeaseDuration(String leaseDuration) {
        this.leaseDuration.set(leaseDuration);
    }

    public String getHallID() {
        return hallID.get();
    }

    public String getHallAdress() {
        return hallAdress.get();
    }

    public String getHallPhoneNumber() {
        return hallPhoneNumber.get();
    }

    public String getStudentID() {
        return studentID.get();
    }

    public void setStudentID(String studentID) {
        this.studentID.set(studentID);
    }

}
