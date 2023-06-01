/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;

/**
 * FXML Controller class
 *
 * @author alejandro
 */
public class Sign_inController implements Initializable {

    @FXML
    private Button sign_up_button;
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Text user_not_found;

    private Club club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sign_up_button.disableProperty().bind(user.textProperty().length().isEqualTo(0).or(password.textProperty().length().isEqualTo(0)));
        user_not_found.setVisible(false);
        
        try {
            club = Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(Sign_inController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sign_inController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OnSignInButtonPressed(ActionEvent event) throws IOException {
        boolean user_exists = club.existsLogin(user.getText());
        
        if (!user_exists) {
            user.textProperty().set("");
            password.textProperty().set("");
            user_not_found.setVisible(true);
        }
        
        else {
            current_user = club.getMemberByCredentials(user.textProperty().getValue(), password.textProperty().getValue());
        
        Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml")); 
        Scene scene = new Scene(root);
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
        }
        
    }
    
}
