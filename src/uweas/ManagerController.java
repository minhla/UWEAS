/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweas;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ma2-le
 */
public class ManagerController implements Initializable {
    
    public void Logout(ActionEvent event) throws IOException {

            Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene loginScene = new Scene(login);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
            window.centerOnScreen();
    }
    
    @FXML private TableView<Table> tableView;
    @FXML private TableColumn<Table, String> leaseNumberCol;
    @FXML private TableColumn<Table, String> hallNameCol;
    @FXML private TableColumn<Table, String> roomNumberCol;
    @FXML private TableColumn<Table, String> studentNameCol;
    @FXML private TableColumn<Table, String> occupancyStatusCol;
    @FXML private TableColumn<Table, String> cleaningStatusCol;
    
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets up the columns in the table
        leaseNumberCol.setCellValueFactory(new PropertyValueFactory<Table, String>("leaseNumber"));
        hallNameCol.setCellValueFactory(new PropertyValueFactory<Table, String>("hallName"));
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<Table, String>("roomNumber"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<Table, String>("studentName"));
        occupancyStatusCol.setCellValueFactory(new PropertyValueFactory<Table, String>("occupancyStatus"));
        cleaningStatusCol.setCellValueFactory(new PropertyValueFactory<Table, String>("cleaningStatus"));
        
        tableView.setItems(getEntries());
    }    
    
    public ObservableList<Table> getEntries(){
        ObservableList<Table> general = FXCollections.observableArrayList();
        general.add(new Table("1021","Glenside","103","Joe Bloggs","Occupied","Clean"));
        general.add(new Table("1231","Frenchay","213","Modern Dolch","Occupied","Clean"));
        general.add(new Table("1021","Blenheim","315","Anthony Baker","Occupied","Dirty"));
        general.add(new Table("1021","Glenside","201","Candy Crush","Occupied","Dirty"));
        return general;
    }
    
}
