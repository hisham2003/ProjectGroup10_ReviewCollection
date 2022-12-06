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
	private Parent root;
	private Stage primaryStage;
	private Scene myScene;
	private ClothesInventorySystemController nextController;
    @FXML
    private Button clothesButton;

    @FXML
    void switchToClothes(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ClothesInventorySystemView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }


    

}
