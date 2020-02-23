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
        
        
        
        for (int i = 0; i < 10; i++){
            
            Room tempRoom = new Room(i+1,
                    1,
                    600,
                    false          
            );
            blenheim.addRoom(tempRoom);
            glenside.addRoom(tempRoom);
            frenchay.addRoom(tempRoom);
            
        } 
        addHall(frenchay);
        addHall(blenheim);
        addHall(glenside);
        
        //Initialize random 10 rooms with a lease
    
        ArrayList<Room> rooms = frenchay.getRooms();
        
        for (int j = 0; j < 3; j++){
        
        Student student = new Student(19035184,"Sean Lew");
        Lease lease = new Lease(student,103,360);

        Room roomHasLease = rooms.get(j);
        if (roomHasLease.getCleaningStatus()!=3 && !roomHasLease.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease.setLease(lease);}
        
        } 
        
        
        rooms = blenheim.getRooms();
        
        for (int j = 0; j < 3; j++){
        
        Student student = new Student(19035184,"Sean Lew");
        Lease lease = new Lease(student,103,360);

        Room roomHasLease = rooms.get(j);
        if (roomHasLease.getCleaningStatus()!=3 && !roomHasLease.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease.setLease(lease);}
        
        } 
        
        
        rooms = glenside.getRooms();
        
        for (int j = 0; j < 3; j++){
        
        Student student = new Student(19035184,"Sean Lew");
        Lease lease = new Lease(student,103,360);

        Room roomHasLease = rooms.get(j);
        if (roomHasLease.getCleaningStatus()!=3 && !roomHasLease.isOccupied()){ //If the room is not Offline, assign the lease
        roomHasLease.setLease(lease);}
        
        } 
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        
        
        primaryStage.setTitle("UWE Accommodation System Login");
        Scene scene;
        scene = new Scene(root, 600, 300);
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
