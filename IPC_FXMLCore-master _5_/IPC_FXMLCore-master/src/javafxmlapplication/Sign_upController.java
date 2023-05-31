/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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


/**
 * FXML Controller class
 *
 * @author alejandro
 */
public class Sign_upController implements Initializable {

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
    private Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            club = Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sign_up_button.disableProperty().bind(
                 name.textProperty().length().isEqualTo(0)
                    .or(surname.textProperty().length().isEqualTo(0)
                    .or(telephon.textProperty().length().isEqualTo(0)
                    .or(username.textProperty().length().isEqualTo(0)
                    .or(repeated_password.textProperty().length().isEqualTo(0)
                    .or(card_number.textProperty().length().isEqualTo(0)
                    .or(CVV.textProperty().length().isEqualTo(0)
                    )))))));

    }    

    @FXML
    private void OnSignInButtonPressed(ActionEvent event) throws ClubDAOException {
        club.registerMember(name.textProperty().getValue(), surname.textProperty().getValue(), telephon.textProperty().getValue(), username.textProperty().getValue(), password.textProperty().getValue(), card_number.textProperty().getValue(), Integer.parseInt(CVV.textProperty().getValue()), image);
    }

    @FXML
    private void UploadFileButtonPressed(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Images", "*.jpg", "*.png"));
        File f = fc.showOpenDialog(null);
        
        if (f != null) {
            image = new Image(f.getAbsolutePath());
        }
    }
    
}
