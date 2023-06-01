/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import javafx.scene.Node;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

import model.Member;
/**
 * FXML Controller class
 *
 * @author stefancostea
 */
public class MainpageController implements Initializable {


    @FXML
    private GridPane field_gridpane;
    @FXML
    private TableView<Member> field_table_view;
    
    private ReadOnlyBooleanProperty hovered_field[][];
    @FXML
    private DatePicker date_picker;
    
   
    /**
     * Initializes the controller class.
     */
    
    
    public MainpageController() {
        hovered_field = new ReadOnlyBooleanProperty[5][13];
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        field_table_view.visibleProperty().bind(field_gridpane.hoverProperty());
        for(Node button : field_gridpane.getChildren()){
            if(button == null) continue;
            if(GridPane.getRowIndex(button) != null && GridPane.getColumnIndex(button) != null){
                hovered_field[GridPane.getColumnIndex(button) -1 ][GridPane.getRowIndex(button) - 1] = button.hoverProperty();
            }
        }
    }    

    @FXML
    private void date_selected(ActionEvent event) {

    }
    
}
