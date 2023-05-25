/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.collections.ObservableList;


/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private CheckMenuItem enable_button;
    @FXML
    private Button button;
    @FXML
    private ListView<String> mylist;
    private ObservableList<String> datos = null;
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button.visibleProperty().bind(enable_button.selectedProperty());
        datos = mylist.getItems();
    }    

    @FXML
    private void onButtonPressed(ActionEvent event) {
        datos.add("ejemplo");
    }
    
}
