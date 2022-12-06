package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainViewController {
	private Stage stage;
	private Scene scene;

    @FXML
    private Button clothesButton;
    @FXML
    private Button techButton;


    @FXML
    void switchToClothes(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ClothesInventorySystemView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    @FXML
    void switchToTech(ActionEvent event) throws IOException {
    	Parent root2 = FXMLLoader.load(getClass().getResource("TechnologyInventoryView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root2);
		stage.setScene(scene);
		stage.show();
    }


    

}
