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
public class Table {
    
    private final SimpleStringProperty leaseNumber;
    private final SimpleStringProperty hallName;
    private final SimpleStringProperty roomNumber;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty occupancyStatus;
    private final SimpleStringProperty cleaningStatus;

    public Table(String leaseNumber, 
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

    //Stuck here

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
    
    
}
