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
/**
 * FXML Controller class
 *
 * @author stefancostea
 */
public class MainpageController implements Initializable {


    private GridPane field_gridpane;
    private TableView<?> field_table_view;
    
    private ReadOnlyBooleanProperty hovered_field[][];
    @FXML
    private DatePicker date_picker;
    
    private LocalDate week;
    
    enum Mode{
        Booking,
        Cancelling
    }
    
    Mode selection_mode = Mode.Booking;
    /**
     * Initializes the controller class.
     */
    
    
    public MainpageController() {
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hovered_field = new ReadOnlyBooleanProperty[5][13];
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
        LocalDate selectedDate = date_picker.getValue();
        week = selectedDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
    
}
