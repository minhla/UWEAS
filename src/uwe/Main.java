package uwe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("UWE Accommodation System Login");
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("uwe_icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        //Reads the data from the csv files
        HashMap<Integer, String> rooms =new HashMap<>();
    }
}
