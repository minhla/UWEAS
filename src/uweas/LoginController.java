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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label labelStatus;

    @FXML
    private TextField username;

    @FXML
    private TextField password;
    
    UWEAS uweasInstanceLogin = new UWEAS();
    
    ObservableList<TableViewRow> dataLogin = FXCollections.observableArrayList(); 
    
    public void passData(ObservableList<TableViewRow> parameterData){
        dataLogin.addAll(parameterData);
    }
    
    public void passInstance(UWEAS parameterInstance){
        uweasInstanceLogin = parameterInstance;
    }
     

    public void Login(ActionEvent event) throws IOException {
        // Manager authentication
        if ((username.getText().equals("manager")) && (password.getText().equals("gromit"))){
            labelStatus.setText("Login success"); 
            UWEAS.getMainInstance().setKeyMain("Manager");
            uweasInstanceLogin = UWEAS.getMainInstance();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Manager.fxml"));
            Parent manager = loader.load();

            Scene managerScene = new Scene(manager);
     

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(managerScene);
            window.show();
            window.centerOnScreen();
        }
        // Warden authentication
        else if (((username.getText().equals("warden") ) && (password.getText().equals("tealios")))){
            FXMLLoader loader = new FXMLLoader();
            UWEAS.getMainInstance().setKeyMain("Warden");
            loader.setLocation(getClass().getResource("Manager.fxml"));
            Parent warden = loader.load();
            Scene wardenScene = new Scene(warden);
           
          

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(wardenScene);

            window.show();
            window.centerOnScreen();
        }
        else {
            labelStatus.setText("Wrong username/password");
        }
    }

    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        
    }    
    
}
