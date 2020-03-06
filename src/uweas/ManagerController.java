/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ma2-le
 */
public class ManagerController implements Initializable {


    public void Logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent login = loader.load();

        Scene loginScene = new Scene(login);

        LoginController controller = loader.getController();
        controller.passData(dataManager);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
        window.centerOnScreen();
    }
    
    List<String> leaseNumberList = new ArrayList<>();
    ArrayList<String> studentNumberList = new ArrayList<>();

    ObservableList<String> cleaningStatusList = FXCollections.observableArrayList("Clean", "Dirty", "Offline");
    
    @FXML
    private Label totalRooms;
    @FXML
    private Label availRooms;
    @FXML
    private Label footerText;
    @FXML
    private Button createLeaseButton;
    @FXML
    private Button deleteLeaseButton;
    @FXML
    private TableView<TableViewRow> tableView;
    @FXML
    private TableColumn<TableViewRow, String> leaseNumberCol;
    @FXML
    private TableColumn<TableViewRow, String> hallNameCol;
    @FXML
    private TableColumn<TableViewRow, String> roomNumberCol;
    @FXML
    private TableColumn<TableViewRow, String> studentNameCol;
    @FXML
    private TableColumn<TableViewRow, String> occupancyStatusCol;
    @FXML
    private TableColumn<TableViewRow, String> cleaningStatusCol;
    @FXML
    private ComboBox cleaningStatusBox;
    @FXML
    private CheckBox isOccupiedBox;
    @FXML
    private TextField hallIDField;
    @FXML
    private TextField hallNameField;
    @FXML
    private TextField hallAddressField;
    @FXML
    private TextField hallPhoneNumberField;
    @FXML
    private TextField roomNumberField;
    @FXML
    private TextField studentIDField;
    @FXML
    private TextField studentNameField;
    @FXML
    private TextField monthlyRentField;
    @FXML
    private TextField leaseDurationField;
    @FXML
    private TextField leaseNumberField;

    ObservableList<TableViewRow> dataManager = FXCollections.observableArrayList();
    
    

    public void passData(ObservableList<TableViewRow> parameterData) {
        dataManager.addAll(parameterData);
    }
    
    private int totalRoomsNumber;

    public int getTotalRoomsNumber() {
        return totalRoomsNumber;
    }

    public void setTotalRoomsNumber(int totalRoomsNumber) {
        this.totalRoomsNumber = totalRoomsNumber;
    }
    
    private int occupiedRoomsNumber;

    public int getOccupiedRoomsNumber() {
        return occupiedRoomsNumber;
    }

    public void setOccupiedRoomsNumber(int occupiedRoomsNumber) {
        this.occupiedRoomsNumber = occupiedRoomsNumber;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<Hall> halls = UWEAS.getMainInstance().getHalls();
        for (int i = 0; i < halls.size(); i++) {

            Hall currentHall = halls.get(i);
            ArrayList<Room> rooms = currentHall.getRooms();

            for (int j = 0; j < rooms.size(); j++) {
                Room room = rooms.get(j);
                totalRoomsNumber++; //GET THE TOTAL AMOUNT OF ROOMS

                Student student = null;
                String leaseNumber = "";
                boolean OccStatus = false;
                String OccStatusString = "";
                int leaseDur = 0;
                String studentName = "";
                int studentID = 0;
                String cleaningStatus = "";

                if (room.isOccupied()) {
                    Lease lease = room.getLease();
                    student = lease.getStudent();
                    leaseNumber = String.valueOf(lease.getLeaseNo());
                    leaseNumberList.add(leaseNumber);
                    studentNumberList.add(String.valueOf(student.getStudentID()));
                    occupiedRoomsNumber++;
                    OccStatus = true;
                    leaseDur = lease.getLeaseDuration();
                    
                }

                if (OccStatus == true) {
                    OccStatusString = "Occupied";
                } else {
                    OccStatusString = "Vacant";
                }

                if (student != null) {
                    studentName = student.getStudentName();
                    studentID = student.getStudentID();
                }

                switch (room.getCleaningStatus()) {
                    case 1:
                        cleaningStatus = "Clean";
                        break;
                    case 2:
                        cleaningStatus = "Dirty";
                        break;
                    case 3:
                        cleaningStatus = "Offline";
                        break;
                }

                TableViewRow row = new TableViewRow(
                        String.valueOf(currentHall.getHallName()),
                        String.valueOf(currentHall.getAddress()),
                        String.valueOf(currentHall.getHallID()),
                        String.valueOf(currentHall.getTel()),
                        String.valueOf(room.getRoomNumber()),
                        OccStatus,
                        OccStatusString,
                        cleaningStatus,
                        String.valueOf(room.getMonthlyRate()),
                        leaseNumber,
                        String.valueOf(leaseDur),
                        String.valueOf(studentID),
                        studentName,
                        currentHall,
                        room
                        
                );

                dataManager.add(row);

            }
        }
        
        totalRooms.setText(String.valueOf(totalRoomsNumber));
        availRooms.setText(String.valueOf(totalRoomsNumber-occupiedRoomsNumber));

        // Sets up the columns in the table
        leaseNumberCol.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        hallNameCol.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        occupancyStatusCol.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        cleaningStatusCol.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));

        tableView.setItems(dataManager);

        cleaningStatusBox.setValue("Clean");
        cleaningStatusBox.setItems(cleaningStatusList);

        if (UWEAS.getMainInstance().getKeyMain() == "Warden") {
            footerText.setText("UWE Accommodation System | Logged in as: Warden");
            hallNameField.setEditable(false);
            hallAddressField.setEditable(false);
            hallIDField.setEditable(false);
            hallPhoneNumberField.setEditable(false);
            studentIDField.setEditable(false);
            studentNameField.setEditable(false);
            monthlyRentField.setEditable(false);
            leaseDurationField.setEditable(false);
            leaseNumberField.setEditable(false);
            roomNumberField.setEditable(false);
            cleaningStatusBox.setEditable(true);
            isOccupiedBox.setDisable(true);
            createLeaseButton.setVisible(false);
            deleteLeaseButton.setVisible(false);

        } else {
            footerText.setText("UWE Accommodation System | Logged in as: Manager");
            cleaningStatusBox.setDisable(true);
            
        }

        tableView.setRowFactory(tableView -> {
            TableRow<TableViewRow> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                TableViewRow data = row.getItem();
                if (data != null) {
                    leaseInfo(data, tableView);
                }

            });
            return row;

        });
        

    }

    private void leaseInfo(TableViewRow row, TableView tableView) {
        hallIDField.setText(row.getHallID());
        hallNameField.setText(row.getHallName());
        hallAddressField.setText(row.getHallAdress());
        hallPhoneNumberField.setText(row.getHallPhoneNumber());
        roomNumberField.setText(row.getRoomNumber());
        if (row.isOccupied()) {
            isOccupiedBox.setSelected(true);
            leaseNumberField.setText(row.getLeaseNumber());
            leaseDurationField.setText(row.getLeaseDuration());
            studentIDField.setText(row.getStudentID());
            studentNameField.setText(row.getStudentName());
        } else {
            leaseNumberField.setText("");
            leaseDurationField.setText("");
            studentIDField.setText("");
            studentNameField.setText("");
            isOccupiedBox.setSelected(false);
        }
        cleaningStatusBox.getSelectionModel().select(row.getCleaningStatus());
        monthlyRentField.setText(row.getMonthlyRent());

    }
    
    

    @FXML
    void createLease(ActionEvent event) {
        TableViewRow selection = tableView.getSelectionModel().getSelectedItem();
        if (selection.getLeaseNumber() == "") {
            if (selection.getCleaningStatus() == "Offline") {
                System.out.println("LEASES CANNOT BE CREATED FOR AN OFFLINE ROOM!");
                createAlertBox(Alert.AlertType.ERROR, "Error", "Room is offline", "Can not add lease to an offline room");
            } else if (selection.isOccupied()) {
                System.out.println("LEASES CANNOT BE CREATED FOR AN OCCUPIED ROOM!");
                createAlertBox(Alert.AlertType.ERROR, "Error", "Room is occupied", "Can not add lease to an occupied room");
            } else if (leaseNumberField.getText().trim().isEmpty() || leaseDurationField.getText().trim().isEmpty()) {
                System.out.println("PLEASE ENTER LEASE INFORMATION!");
                createAlertBox(Alert.AlertType.ERROR, "Error", "Missing information", "Please enter valid lease information");
            } else if (studentNameField.getText().trim().isEmpty() || studentIDField.getText().trim().isEmpty()) {
                System.out.println("PLEASE ENTER STUDENT INFORMATION!");
                createAlertBox(Alert.AlertType.ERROR, "Error", "Missing information", "Please enter valid student information");
            } else if (checkLeaseNumber(leaseNumberField.getText())) {
                System.out.println("LEASE NUMBER ALREADY EXISTS!");
                createAlertBox(Alert.AlertType.ERROR, "Error", "Lease number already exist", "Please enter valid student information");
            } else if(checkStudentNumber(studentIDField.getText())){
                createAlertBox(Alert.AlertType.ERROR, "Error", "Student ID already exist", "Please try another value");
            }
            else
            {
                selection.setLeaseNumber(leaseNumberField.getText());
                leaseNumberList.add(leaseNumberField.getText());
                selection.setLeaseDuration(leaseDurationField.getText());
                selection.setIsOccupied(true);
                selection.setOccupancyStatus("Occupied");
                selection.setStudentName(studentNameField.getText());
                selection.setStudentID(studentIDField.getText());
                occupiedRoomsNumber++;
                studentNumberList.add(selection.getStudentID());
                availRooms.setText(String.valueOf(totalRoomsNumber-occupiedRoomsNumber));
                int cleaningStatus;
                if(selection.getCleaningStatus()=="Clean"){
                    cleaningStatus=1;
                }
                else{
                    cleaningStatus=2;
                }
                Room tempRoom = new Room(Integer.parseInt(selection.getRoomNumber()),cleaningStatus,Integer.parseInt(selection.getMonthlyRent()),true);
                selection.setRoom(tempRoom);
                
                if(selection.getOccupancyStatus()=="Occupied"){
                    Lease tempLease = tempRoom.getLease();
                    
                }
                tableView.refresh();
                
                System.out.println("LEASE HAS BEEN CREATED!");
            }
        } else {
            System.out.println("LEASE ALREADY EXISTS!");
            createAlertBox(Alert.AlertType.ERROR, "Error", "Lease already exist", "Please try again with another room or delete the current lease");
        }
        
        
    }

    @FXML
    void deleteLease(ActionEvent event) {
        TableViewRow selection = tableView.getSelectionModel().getSelectedItem();

        if (selection.getLeaseNumber() != "" || selection.isOccupied()) {
            studentNumberList.remove(selection.getStudentID());
            selection.setLeaseNumber("");
            selection.setLeaseDuration("");
            selection.setIsOccupied(false);
            selection.setOccupancyStatus("Vacant");
            selection.setStudentID("");
            selection.setStudentName("");
            occupiedRoomsNumber--;
            availRooms.setText(String.valueOf(totalRoomsNumber-occupiedRoomsNumber));
            
            tableView.refresh();
            
            System.out.println("Lease has been removed.");
        } else {
            createAlertBox(Alert.AlertType.ERROR, "Error", "Lease not found", "You can only delete lease in a room with an existing lease");
        }
        
       
    }
    
    
    @FXML void applyChanges(ActionEvent event) {
        TableViewRow selection = tableView.getSelectionModel().getSelectedItem();
        
        if(UWEAS.getMainInstance().getKeyMain() == "Warden"){           
            if(cleaningStatusBox.getValue()=="Offline" && selection.getOccupancyStatus()=="Occupied"){
                createAlertBox(Alert.AlertType.ERROR, "Error", "Room is occupied", "You can not set a room to Offline when there is a tenant in it.");
            }
            else {
                selection.setCleaningStatus(String.valueOf(cleaningStatusBox.getValue()));
                System.out.println("Cleaning status for room " + selection.getRoomNumber() + " in hall " + selection.getHallName() + " has been set to " + selection.getCleaningStatus());
            }
            
            tableView.refresh();
            
            
        }
        else if (UWEAS.getMainInstance().getKeyMain() == "Manager"){
            //edit room details without cleaning
            if(!monthlyRentField.getText().trim().isEmpty()){
            selection.setMonthlyRent(monthlyRentField.getText());
            
            }
            else {
                createAlertBox(Alert.AlertType.ERROR, "Error", "Can not add new data", "If you want to add new data, use the create lease function instead.");
            }
            
            if(!isOccupiedBox.isSelected() && selection.getOccupancyStatus()=="Occupied"){
            createAlertBox(Alert.AlertType.ERROR, "Error", "Room currently has a tenant", "You can only delete the lease or update other details.");
            }
            
            if(studentNameField.getText()!=null){
            selection.setStudentName(studentNameField.getText());
            }
            else {
                createAlertBox(Alert.AlertType.ERROR, "Error", "Can not add new data", "If you want to add new data, use the create lease function instead.");
            }
            
            if(studentIDField.getText()!=""){
            selection.setStudentID(studentIDField.getText());
            }
            else {
                createAlertBox(Alert.AlertType.ERROR, "Error", "Can not add new data", "If you want to add new data, use the create lease function instead.");
            }
            if(leaseNumberField.getText()!=""){
            selection.setLeaseNumber(leaseNumberField.getText());
            }
            else {
                createAlertBox(Alert.AlertType.ERROR, "Error", "Can not add new data", "If you want to add new data, use the create lease function instead.");
            }
            
            if(leaseDurationField.getText()!=""){
            selection.setLeaseDuration(leaseDurationField.getText());
            }
            else {
                createAlertBox(Alert.AlertType.ERROR, "Error", "Can not add new data", "If you want to add new data, use the create lease function instead.");
            }
            
            
            tableView.refresh();
            
        }
        
    }
    
    

    void createAlertBox(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("uweas/uwe_icon.png"));
        alert.showAndWait();
        
    }

    boolean checkLeaseNumber(String checkLeaseNum) {
        for (int i = 0; i < leaseNumberList.size(); i++) {
            if (leaseNumberList.contains(checkLeaseNum)) {
                System.out.println("Lease number already existed");
                return true;
            }
        }
        return false;
    }
    
    boolean checkStudentNumber(String stdNumber){
        for (int i = 0; i < studentNumberList.size(); i++) {
            if (studentNumberList.contains(stdNumber)) {
                System.out.println("Student number already existed");
                return true;
            }
        }
        return false;
    }
}
