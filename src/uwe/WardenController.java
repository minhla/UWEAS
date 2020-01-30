package uwe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WardenController {
    public void Logout(ActionEvent event) throws IOException {

        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene loginScene = new Scene(login);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
        window.centerOnScreen();
    }
}
