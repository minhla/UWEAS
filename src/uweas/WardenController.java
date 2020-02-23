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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ma2-le
 */
public class WardenController implements Initializable {
    
    ObservableList<String> cleaningStatusList = FXCollections.observableArrayList("Clean","Dirty","Offline");
    
    @FXML private TableView<TableViewRow> tableView;
    @FXML private TableColumn<TableViewRow, String> leaseNumberCol;
    @FXML private TableColumn<TableViewRow, String> hallNameCol;
    @FXML private TableColumn<TableViewRow, String> roomNumberCol;
    @FXML private TableColumn<TableViewRow, String> studentNameCol;
    @FXML private TableColumn<TableViewRow, String> occupancyStatusCol;
    @FXML private TableColumn<TableViewRow, String> cleaningStatusCol;
    
    @FXML private ComboBox cleaningStatusBox;
    @FXML private CheckBox isOccupiedBOx;
    
    ObservableList<TableViewRow> dataWarden = FXCollections.observableArrayList();
    UWEAS uweasInstanceWarden = new UWEAS();
    

    
    public void passData(ObservableList<TableViewRow> parameterData){
        dataWarden.addAll(parameterData);
    }
    
    
    
    
    public void Logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent login = loader.load();
        Scene loginScene = new Scene(login);
        
        LoginController controller = loader.getController();
        controller.passData(dataWarden);
        controller.passInstance(uweasInstanceWarden);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
        window.centerOnScreen();
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Make it almost the same as Manager Controller file.
    }    
    
}
