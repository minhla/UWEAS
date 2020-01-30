package uwe;

public class Lease {
    private Student student;
    private int leaseNumber;
    private int leaseDuration;

    public Lease(Student student, int leaseNumber, int leaseDuration) {
        this.student = student;
        this.leaseNumber = leaseNumber;
        this.leaseDuration = leaseDuration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getLeaseNumber() {
        return leaseNumber;
    }

    public void setLeaseNumber(int leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public int getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }
}
