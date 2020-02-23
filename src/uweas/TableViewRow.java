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
    
    private SimpleStringProperty leaseNumber;
    private SimpleStringProperty hallName;
    private SimpleStringProperty roomNumber;
    private SimpleStringProperty studentName;
    private SimpleStringProperty occupancyStatus;
    private SimpleStringProperty cleaningStatus;
    
    private SimpleStringProperty leaseDuration;
    private SimpleStringProperty hallID;
    private SimpleStringProperty hallAdress;
    private SimpleStringProperty hallPhoneNumber;
    private SimpleStringProperty studentID;
    private SimpleStringProperty monthlyRent;
    private boolean occupancyStatusCheckBox;

    public String getMonthlyRent() {
        return monthlyRent.get();
    } 
    

    public TableViewRow(String leaseNumber, //Constructor for TableView
            String hallName, 
            String roomNumber, 
            String studentName, 
            String occupancyStatus, 
            String cleaningStatus) {
        this.leaseNumber = new SimpleStringProperty(leaseNumber);
        this.hallName = new SimpleStringProperty(hallName);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.studentName = new SimpleStringProperty(studentName);
        this.occupancyStatus = new SimpleStringProperty(occupancyStatus);
        this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
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
            String studentName
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
        occupancyStatusCheckBox = occupancyStatusBool;
        this.occupancyStatus = new SimpleStringProperty(occupancyStatus);
        this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
    }

    public boolean isOccupancyStatusCheckBox() {
        return occupancyStatusCheckBox;
    }

    public void setOccupancyStatusCheckBox(boolean occupancyStatusCheckBox) {
        this.occupancyStatusCheckBox = occupancyStatusCheckBox;
    }
    


    public String getLeaseNumber() {
        return leaseNumber.get();
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

    public String getOccupancyStatus() {
        return occupancyStatus.get();
    }

    public String getCleaningStatus() {
        return cleaningStatus.get();
    }

    public String getLeaseDuration() {
        return leaseDuration.get();
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
    
    
}
