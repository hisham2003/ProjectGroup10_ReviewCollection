package application;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
/**
 * The controller for the Main menu for inventory System 
 * that allows user to choose type of inventory system
 * @author HishamSO
 *
 */
public class MainViewController {
	private Stage stage;
	private Scene scene;

    @FXML
    private Button clothesButton;
    @FXML
    private Button techButton;
    @FXML
    private ImageView imageView;

    /**
     * Switches to the Clothes inventory Scene utilizing this button
     * @param event
     * @throws IOException
     */
    @FXML
    void switchToClothes(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ClothesInventorySystemView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    /**
     * Switches to the Technology inventory Scene utilizing this button
     * @param event
     * @throws IOException
     */
    @FXML
    void switchToTech(ActionEvent event) throws IOException {
    	Parent root2 = FXMLLoader.load(getClass().getResource("TechnologyInventoryView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root2);
		stage.setScene(scene);
		stage.show();
    }
	
	
    


    

}
