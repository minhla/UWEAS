/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ma2-le
 */
public class ManagerController implements Initializable {
    
    public void setDataBelow(ActionEvent event) throws IOException {
        TableViewRow currentRow = tableView.getSelectionModel().getSelectedItem();
        hallIDField.setText(currentRow.getHallID());
        hallAddressField.setText(currentRow.getHallAdress());
        hallPhoneNumberField.setText(currentRow.getHallPhoneNumber());
        
    }
    
    
    public void Logout(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Login.fxml"));
            Parent login = loader.load();

            Scene loginScene = new Scene(login);
            
            LoginController controller = loader.getController();
            controller.passData(dataManager);


            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
            window.centerOnScreen();
    }
    
    ObservableList<String> cleaningStatusList = FXCollections.observableArrayList("Clean","Dirty","Offline");
    
    @FXML private TableView<TableViewRow> tableView;
    @FXML private TableColumn<TableViewRow, String> leaseNumberCol;
    @FXML private TableColumn<TableViewRow, String> hallNameCol;
    @FXML private TableColumn<TableViewRow, String> roomNumberCol;
    @FXML private TableColumn<TableViewRow, String> studentNameCol;
    @FXML private TableColumn<TableViewRow, String> occupancyStatusCol;
    @FXML private TableColumn<TableViewRow, String> cleaningStatusCol;
    
    @FXML private ComboBox cleaningStatusBox;
    @FXML private CheckBox isOccupiedBox;
    
    @FXML private TextField hallIDField;
    @FXML private TextField hallNameField;
    @FXML private TextField hallAddressField;
    @FXML private TextField hallPhoneNumberField;
    @FXML private TextField roomNumberField;
    @FXML private TextField studentIDField;
    @FXML private TextField studentNameField;
    @FXML private TextField monthlyRentField;
    @FXML private TextField leaseDurationField;
    @FXML private TextField leaseNumberField;
    
    ObservableList<TableViewRow> dataManager = FXCollections.observableArrayList();

    
    public void passData(ObservableList<TableViewRow> parameterData){
        dataManager.addAll(parameterData);
    }
    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ArrayList<Hall> halls = UWEAS.getMainInstance().getHalls();
        for (int i=0 ; i < halls.size() ; i++){
            
            Hall currentHall = halls.get(i);
            ArrayList<Room> rooms = currentHall.getRooms();
            
            for (int j = 0 ; j < rooms.size() ;  j++){
                Room room = rooms.get(j);
                
                Student student = null;
                String leaseNumber = "";
                boolean OccStatus = false;
                String OccStatusString = "";           
                int leaseDur = 0;                
                String studentName = ""; 
                int studentID = 0;
                String cleaningStatus = "";
                
               
                
                if (room.isOccupied()){
                    Lease lease = room.getLease();
                    student = lease.getStudent();
                    leaseNumber = String.valueOf(lease.getLeaseNo());
                    OccStatus = true;
                    leaseDur = lease.getLeaseDuration();
                }
                
                if (OccStatus == true){
                    OccStatusString = "Occupied";
                }
                else {
                    OccStatusString = "Vacant";
                }
                
                
                
                if (student != null){
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
                                    studentName
                  
                );

                   
                
                dataManager.add(row);
             
            }
        }
       
        
        
        
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
        
        if (UWEAS.getMainInstance().getKeyMain()=="Warden"){
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
        }
        else {
            cleaningStatusBox.setEditable(false);  
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
        if(row.isOccupancyStatusCheckBox()){
            isOccupiedBox.setSelected(true);
            leaseNumberField.setText(row.getLeaseNumber());
            leaseDurationField.setText(row.getLeaseDuration());
            studentIDField.setText(row.getStudentID());
            studentNameField.setText(row.getStudentName());
        }
        else {
            leaseNumberField.setText("");
            leaseDurationField.setText("");
            studentIDField.setText("");
            studentNameField.setText("");
            isOccupiedBox.setSelected(false);
        }
        cleaningStatusBox.getSelectionModel().select(row.getCleaningStatus());
        monthlyRentField.setText(row.getMonthlyRent());
        
        
        
        
        
    }

    
    
    
}
