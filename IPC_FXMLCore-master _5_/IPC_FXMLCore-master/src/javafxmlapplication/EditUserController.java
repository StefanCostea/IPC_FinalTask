/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableBooleanValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Club;
import model.ClubDAOException;
import model.Member;


/**
 * FXML Controller class
 *
 * @author alejandro
 */
public class EditUserController implements Initializable {

    @FXML
    private Button sign_up_button;
    @FXML
    private TextField password;
    @FXML
    private Text user_not_found;
    
    private Club club;
    @FXML
    private TextField surname;
    @FXML
    private TextField name;
    @FXML
    private TextField telephon;
    @FXML
    private TextField username;
    @FXML
    private TextField repeated_password;
    @FXML
    private TextField card_number;
    @FXML
    private TextField CVV;
    private Image image = null;
    @FXML
    private Button upload_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            club = Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        user_not_found.setVisible(false);
        sign_up_button.disableProperty().bind(
                 name.textProperty().length().isEqualTo(0)
                    .or(surname.textProperty().length().isEqualTo(0)
                    .or(telephon.textProperty().length().isEqualTo(0)
                    .or(repeated_password.textProperty().length().isEqualTo(0)
                    .or(card_number.textProperty().length().isEqualTo(0)
                    .or(CVV.textProperty().length().isEqualTo(0)
                    .or(password.textProperty().isEqualTo(repeated_password.textProperty()))

                    ))))));

        password.textProperty().addListener(e->{
            if(password.getText().equals(repeated_password.getText()) != true){
                user_not_found.setText("Las contraseñas no son iguales");
                user_not_found.setVisible(true);
            }else{
                user_not_found.setText("El usuario o la contraseña no son correctos");
                user_not_found.setVisible(false);
            }
        });
        
        repeated_password.textProperty().addListener(e->{
            if(password.getText().equals(repeated_password.getText()) != true){
                user_not_found.setText("Las contraseñas no son iguales");
                user_not_found.setVisible(true);
            }else{
                user_not_found.setText("El usuario o la contraseña no son correctos");
                user_not_found.setVisible(false);
            }
        });
        
        card_number.textProperty().addListener(e->{
            boolean is_number;
            try {
                Integer.parseInt(card_number.getText());
                is_number = true;
            } catch(Exception exc) {
                is_number = false;
            }
            
            
            if(is_number == false){
                user_not_found.setText("La tarjeta y el CVV no pueden contener letras.");
                user_not_found.setVisible(true);
            }else{
                user_not_found.setText("El usuario o la contraseña no son correctos");
                user_not_found.setVisible(false);
            }
        });
            
            CVV.textProperty().addListener(e->{
            boolean is_number;
            try {
                Integer.parseInt(card_number.getText());
                is_number = true;
            } catch(Exception exc) {
                is_number = false;
            }
            
            
            if(is_number == false){
                user_not_found.setText("La tarjeta y el CVV no pueden contener letras.");
                user_not_found.setDisable(false);
            }else{
                user_not_found.setText("El usuario o la contraseña no son correctos");
                user_not_found.setDisable(true);
            }
        });
    }    

    @FXML
    private void OnSignInButtonPressed(ActionEvent event) throws ClubDAOException {
        
    }

    @FXML
    public void UploadFileButtonPressed(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Images", "*.jpg", "*.png"));
        File f = fc.showOpenDialog(null);
        
        if (f != null) {
                String fileLocation = f.toURI().toString();
                image = new Image(fileLocation);
            }
        }
    }
