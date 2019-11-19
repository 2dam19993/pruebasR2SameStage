/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasreto2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController2 implements Initializable {
    private Stage stage;
    
    
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
     public void initStage(Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("App");
        
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void volver(){
         try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("primera.fxml"));
        
        Parent root = (Parent)loader.load();

        FXMLDocumentController controller = ((FXMLDocumentController)loader.getController());
        controller.setStage(stage);
        controller.initStage(root);
        } catch (IOException e) {
            System.out.println("error 1 "+e);
        }
    }
    
}
