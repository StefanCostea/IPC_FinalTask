/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sign_up_button.disableProperty().bind(user.textProperty().length().isEqualTo(0).or(password.textProperty().length().isEqualTo(0)));
        user_not_found.setVisible(false);
    }

    @FXML
    private void OnSignInButtonPressed(ActionEvent event) {
        user.textProperty().set("");
        password.textProperty().set("");
        user_not_found.setVisible(true);
    }
    
}
