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
    
    @FXML private TableView<General> tableView;
    @FXML private TableColumn<General, Integer> leaseNumberCol;
    @FXML private TableColumn<General, String> hallNameCol;
    @FXML private TableColumn<General, Integer> roomNumberCol;
    @FXML private TableColumn<General, String> studentNameCol;
    @FXML private TableColumn<General, String> occupancyStatusCol;
    @FXML private TableColumn<General, String> cleaningStatusCol;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public ObservableList<General> getEntries(){
        ObservableList<General> general = FXCollections.observableArrayList();
        
        return general;
    }
    
}
