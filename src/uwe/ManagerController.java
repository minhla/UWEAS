package uwe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerController {
    public void Logout(ActionEvent event) throws IOException {

            Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene loginScene = new Scene(login);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
            window.centerOnScreen();
    }
    @FXML private TableView<Lease> tableView;
    @FXML private TableColumn<Lease,Integer> LeaseNumber;
    @FXML private TableColumn<Lease, String> HallName;
    @FXML private TableColumn<Lease, Integer> RoomNumber;
    @FXML private TableColumn<Lease, String> StudentName;
    @FXML private TableColumn<Lease, Boolean> OccStatus;
    @FXML private TableColumn<Lease, Integer> CleaningStatus;
    @FXML private TableColumn<Lease, Boolean> Availability;


    private ObservableList<Lease> getLease(){
        ObservableList<Lease> leases = FXCollections.observableArrayList();
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));
        leases.add(new Lease(new Student(19035184,"Minh Le"),135,6));

        return leases;
    }

}
