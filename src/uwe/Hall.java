package uwe;
import java.util.ArrayList;

public class Hall {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private int hallID;
    private String name;
    private String address;
    private String tel;

    public Hall(ArrayList<Room> rooms, int hallID, String name, String address, String tel) {
        this.rooms = rooms;
        this.hallID = hallID;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
