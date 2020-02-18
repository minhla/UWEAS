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
public class General {
    
    private Lease lease;
    private Hall hall;
    private Room room;
    private Student student;

    public General(Lease lease, Hall hall, Room room, Student student) {
        this.lease = lease;
        this.hall = hall;
        this.room = room;
        this.student = student;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
}
