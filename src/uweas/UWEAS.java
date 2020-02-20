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
    
    private ArrayList<Hall> halls;

    private static UWEAS instance;

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
                "0117 7496 0554");
        Hall frenchay = new Hall(103,
                "Frenchay",
                "UWE Bristol, Coldharbour Lane, Frenchay, Bristol",
                "0117 7496 0085");
        int[] cleaningStatusInt = new int[]{1,2,3}; //1 for Clean, 2 for Dirty and 3 for Offline
        int[] monthlyRateInt = new int[]{300,400,600,800};
        for (int i = 0; i < 100; i++){
            int rnd = new Random().nextInt(cleaningStatusInt.length);
            int cleaningStatus = cleaningStatusInt[rnd];
            rnd = new Random().nextInt(monthlyRateInt.length);
            int monthlyRate = monthlyRateInt[rnd];
            Room tempRoom = new Room(i+1,
                    cleaningStatus,
                    monthlyRate,
                    false          
            );
            blenheim.addRoom(tempRoom);
        }
        for (int i = 0; i < 100; i++){
            int rnd = new Random().nextInt(cleaningStatusInt.length);
            int cleaningStatus = cleaningStatusInt[rnd];
            rnd = new Random().nextInt(monthlyRateInt.length);
            int monthlyRate = monthlyRateInt[rnd];
            Room tempRoom = new Room(i+1,
                    cleaningStatus,
                    monthlyRate,
                    false          
            );
            frenchay.addRoom(tempRoom);
            
        }
        for (int i = 0; i < 100; i++){
            int rnd = new Random().nextInt(cleaningStatusInt.length);
            int cleaningStatus = cleaningStatusInt[rnd];
            rnd = new Random().nextInt(monthlyRateInt.length);
            int monthlyRate = monthlyRateInt[rnd];
            Room tempRoom = new Room(i+1,
                    cleaningStatus,
                    monthlyRate,
                    false          
            );
            glenside.addRoom(tempRoom);
            
        } 
        addHall(frenchay);
        addHall(blenheim);
        addHall(glenside);
        
        //Initialize random 10 rooms with a lease
    
        ArrayList<Room> rooms = frenchay.getRooms();
        for (int j = 0; j < 10; j++){
        String[] firstName = new String[]{"Anthony","John","Sean","Brandon","Peter","Luke","Pete","Andrew"};
        String[] lastName = new String[]{"Rodriguez","Davis","Walker","Bennett","Lee","Henry","Alderson","Ackerman"};

        int rndftName = new Random().nextInt(firstName.length);
        int rndltName = new Random().nextInt(lastName.length);

        String studentName =  firstName[rndftName] + lastName[rndltName];
        int studentID = ThreadLocalRandom.current().nextInt(19000000, 19090998 + 1);//Randomly generate student ID

        Student student = new Student(studentID,studentName);
        Lease lease = new Lease(student,100,360);
        int rnd = new Random().nextInt(frenchay.getNumberofRooms());//Get a random room to assign the Lease
        Room roomHasLease = rooms.get(rnd);
        if (roomHasLease.getCleaningStatus()!=3){ //If the room is not Offline, assign the lease
        roomHasLease.setLease(lease);}
        }
        
        rooms = blenheim.getRooms();
        for (int j = 0; j < 10; j++){
        String[] firstName = new String[]{"Anthony","John","Sean","Brandon","Peter","Luke","Pete","Andrew"};
        String[] lastName = new String[]{"Rodriguez","Davis","Walker","Bennett","Lee","Henry","Alderson","Ackerman"};

        int rndftName = new Random().nextInt(firstName.length);
        int rndltName = new Random().nextInt(lastName.length);

        String studentName =  firstName[rndftName] + lastName[rndltName];
        int studentID = ThreadLocalRandom.current().nextInt(19000000, 19090998 + 1);//Randomly generate student ID

        Student student = new Student(studentID,studentName);
        Lease lease = new Lease(student,100,360);
        int rnd = new Random().nextInt(frenchay.getNumberofRooms());//Get a random room to assign the Lease
        Room roomHasLease = rooms.get(rnd);
        roomHasLease.setLease(lease);
        }
        
        rooms = glenside.getRooms();
        for (int j = 0; j < 10; j++){
        String[] firstName = new String[]{"Anthony","John","Sean","Brandon","Peter","Luke","Pete","Andrew"};
        String[] lastName = new String[]{"Rodriguez","Davis","Walker","Bennett","Lee","Henry","Alderson","Ackerman"};

        int rndftName = new Random().nextInt(firstName.length);
        int rndltName = new Random().nextInt(lastName.length);

        String studentName =  firstName[rndftName].toString() + lastName[rndltName].toString();
        int studentID = ThreadLocalRandom.current().nextInt(19000000, 19090998 + 1);//Randomly generate student ID

        Student student = new Student(studentID,studentName);
        Lease lease = new Lease(student,100,360);
        int rnd = new Random().nextInt(frenchay.getNumberofRooms());//Get a random room to assign the Lease
        Room roomHasLease = rooms.get(rnd);
        roomHasLease.setLease(lease);
        }
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("UWE Accommodation System Login");
        Scene scene;
        scene = new Scene(root, 600, 300);
        primaryStage.getIcons().add(new Image("uweas/uwe_icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        
        //Populate the table
        
        final ObservableList<Table> data = FXCollections.observableArrayList();
        UWEAS UWEAS = getInstance();
        UWEAS.populateData();
        
        ArrayList<Hall> halls = UWEAS.getHalls();
        for (int i=0 ; i < halls.size() ; i++){
            Hall currentHall = halls.get(i);
            ArrayList<Room> rooms = currentHall.getRooms();
            
            for (int j = 0 ; j < rooms.size() ;  j++){
                Room room = rooms.get(j);
                
                Student student = null;
                String leaseNumber = "";
                boolean OccStatus = false;
                String OccStatusString = "";
               
                
                if (room.isOccupied()){
                    Lease lease = room.getLease();
                    student = lease.getStudent();
                    leaseNumber = String.valueOf(lease.getLeaseNo());
                    OccStatus = true;
                }
                
                if (OccStatus = true){
                    OccStatusString = "Occupied";
                }
                else {
                    OccStatusString = "Vacant";
                }
                
                String studentName = "";              
                
                if (student != null){
                    studentName = student.getStudentName();
                }
                
                String cleaningStatus = "";
                switch(room.getCleaningStatus()){
                    case 1:
                        cleaningStatus = "Clean";
                    case 2:
                        cleaningStatus = "Dirty";
                    case 3:
                        cleaningStatus = "Offline";
                        
                }
                
                Table row = new Table(leaseNumber,
                                      String.valueOf(currentHall.getHallName()),
                                      String.valueOf(room.getRoomNumber()),
                                      studentName,
                                      OccStatusString,
                                      String.valueOf(cleaningStatus)
                );
                
                data.add(row);
             
            }
        }
        
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
