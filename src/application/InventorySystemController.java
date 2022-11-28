package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InventorySystemController {
	private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Button removeInventory;

    @FXML
    private Button addInventory;

    @FXML
    void swicthToAdd(ActionEvent event) throws IOException {
    	//from youtube video https://www.youtube.com/watch?v=hcM-R-YOKkQ
    	Parent root = FXMLLoader.load(getClass().getResource("InventorySystemView2.fxml"));
    	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
   }
 
    @FXML
    void swicthToRemove(ActionEvent event) {
    	
    }

}
