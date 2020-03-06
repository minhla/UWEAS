/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweas;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author User
 */
public class UWEAS extends Application {
    
    private static UWEAS mainInstance = new UWEAS();
        
    
    private ArrayList<Hall> halls;

    private static UWEAS instance;
    
    private String keyMain = "";

    public String getKeyMain() {
        return keyMain;
    }

    public void setKeyMain(String keyMain) {
        this.keyMain = keyMain;
    }

   
    
    
    
    public static UWEAS getMainInstance() {
        return mainInstance;
    }

    public static UWEAS getInstance() {
        if (instance == null) {
            instance = new UWEAS();
        }
        return instance;
    }
    
    public UWEAS(){
        //ArrayList of Halls
        halls = new ArrayList<Hall>();
    }
    
    public ArrayList<Hall> getHalls(){
        return halls;
    }
    
    public void addHall(Hall hall){
        halls.add(hall);
    }
    

    
    public void populateData(){
        
        //Generate halls
        Hall blenheim = new Hall(101,
                "Bleinheim",
                "Blenheim Court, Marlborough Street, BS1 3NW",
                "0117 7496 0875");
        Hall glenside = new Hall(102,
                "Glenside",
                "UWE Bristol, Blackberry Hill, Fishponds, Bristol, BS16 1DD",
                "0237 7496 0554");
        Hall frenchay = new Hall(103,
                "Frenchay",
                "UWE Bristol, Coldharbour Lane, Frenchay, Bristol",
                "0732 7496 0085");
        
        addHall(frenchay);
        addHall(blenheim);
        addHall(glenside);

        
        for (int i = 0; i < 10; i++){
            
            Room tempRoom = new Room(i+1,
                    1,
                    800,
                    false          
            );
            blenheim.addRoom(tempRoom);
            Room tempRoom2 = new Room(i+1,
                    1,
                    700,
                    false          
            );
            glenside.addRoom(tempRoom2);
            Room tempRoom3 = new Room(i+1,
                    1,
                    500,
                    false          
            );
            frenchay.addRoom(tempRoom3);
            
        } 
       
        
        //Initialize random 3 rooms each hall with a lease
    
        ArrayList<Room> roomsFren = frenchay.getRooms();
        ArrayList<Room> roomsBlen = blenheim.getRooms();
        ArrayList<Room> roomsGlen = glenside.getRooms();

        
        Student student1 = new Student(19035184,"Sean Lew");
        Lease lease1 = new Lease(student1,103,240);
        Room roomHasLease1 = roomsFren.get(4);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        
        student1 = new Student(19035188,"Joe Bloggs");
        lease1 = new Lease(student1,101,360);
        roomHasLease1 = roomsFren.get(5);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        roomHasLease1.setCleaningStatus(2);
        
        student1 = new Student(19034188,"Anthony Stark");
        lease1 = new Lease(student1,102,360);
        roomHasLease1 = roomsFren.get(1);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        
        student1 = new Student(18045192,"Alice Wonder");
        lease1 = new Lease(student1,203,360);
        roomHasLease1 = roomsBlen.get(1);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        roomHasLease1.setCleaningStatus(2);
        
        student1 = new Student(16055192,"Frank Sinatraa");
        lease1 = new Lease(student1,201,480);
        roomHasLease1 = roomsBlen.get(9);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        
        student1 = new Student(17089322,"John Doe");
        lease1 = new Lease(student1,205,120);
        roomHasLease1 = roomsBlen.get(5);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        roomHasLease1.setCleaningStatus(2);
        
        student1 = new Student(18089422,"Simon Sez");
        lease1 = new Lease(student1,309,120);
        roomHasLease1 = roomsGlen.get(4);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        roomHasLease1.setCleaningStatus(2);
        
        student1 = new Student(17129422,"Tuan Nguyen");
        lease1 = new Lease(student1,301,120);
        roomHasLease1 = roomsGlen.get(8);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        
        student1 = new Student(19089312,"Raul Gin");
        lease1 = new Lease(student1,309,120);
        roomHasLease1 = roomsGlen.get(9);
        if (roomHasLease1.getCleaningStatus()!=3 && !roomHasLease1.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease1.setLease(lease1);}
        roomHasLease1.setCleaningStatus(2);
        
        Room temporaryRoom = roomsFren.get(2);
        temporaryRoom.setCleaningStatus(3);
        
        temporaryRoom = roomsBlen.get(7);
        temporaryRoom.setCleaningStatus(3);
        

        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        
        
        primaryStage.setTitle("UWE Accommodation System Login");
        Scene scene;
        scene = new Scene(root, 585, 300);
        primaryStage.getIcons().add(new Image("uweas/uwe_icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainInstance.populateData();
        mainInstance.setKeyMain("Manager");
        launch(args);
        
        
    }
    
}
