/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author Stefan
 */
public class RegistrationController implements Initializable {   
     
    @FXML
    private VBox vbox;    
    private Parent fxml;
    
    private boolean is_in_animation = false;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), vbox);
        transition.setToX(-vbox.getLayoutX() +20);
        transition.play();
        transition.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    }
    @FXML
    private void open_signin(ActionEvent event){
        if (is_in_animation) {
            return;
        }
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), vbox);
        is_in_animation = true;
        transition.setToX(0);
        transition.play();
        transition.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
                is_in_animation = false;
            }catch(IOException ex){
                
            }finally{
                is_in_animation = false;
            }
        });
    }   
    @FXML
    private void open_signup(ActionEvent event){
        if (is_in_animation) {
            return;
        }
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), vbox);
        is_in_animation = true;
        transition.setToX(-vbox.getLayoutX() + 20);
        transition.play();
        transition.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }finally{
                is_in_animation = false;
            }
        });
    } 
    @FXML
    private void close_program(ActionEvent event){
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }
    }
    

