/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import javafx.scene.Node;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.util.Pair;

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
    
    @FXML
    private DatePicker date_picker;
    
    private Boolean hovered_fields[][];
    
    LocalDate monday_of_the_week;
    
   
    /**
     * Initializes the controller class.
     */
    
    
    public MainpageController() {
        hovered_fields = new Boolean[5][14];
        for(int i = 0; i<hovered_fields.length; i++){
             for(int j = 0; j<hovered_fields[i].length; j++){
                 hovered_fields[i][j] = false;
             }
        }
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Node e : field_gridpane.getChildren()){
            e.setOnMouseEntered(o->{
                hovered_fields[GridPane.getColumnIndex(e)][GridPane.getRowIndex(e)] = true;
                table_update();
                field_table_view.setVisible(true);
                System.out.println("SI");
            });
            e.setOnMouseExited(o->{
                hovered_fields[GridPane.getColumnIndex(e)][GridPane.getRowIndex(e)] = false;
                field_table_view.setVisible(false);
                System.out.println("NO");
            });
        }
    }

    private Pair get_hovered_field(){
        for(int i = 0; i<hovered_fields.length; i++){
            for(int j = 0; j<hovered_fields[i].length;j++){
                if(hovered_fields[i][j] == true){
                    return new Pair(i,j);
                }
            }
        }
        return null;
    }

    @FXML
    private void date_selected(ActionEvent event) {
        LocalDate selectedDate = date_picker.getValue();
        monday_of_the_week = selectedDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
    
    private LocalDateTime get_selected_field_time(){
        int hours = 9;
        int day = 0;
        LocalDate result;
        if(monday_of_the_week == null){
            System.out.println("AUN NO SE HA ESCOGIDO FECHA");
            return null;
        }
        result = monday_of_the_week.withYear(monday_of_the_week.getYear())
                                   .withMonth(monday_of_the_week.getMonthValue())
                                   .withDayOfMonth(monday_of_the_week.getDayOfMonth());
        
        Pair hovered_field = get_hovered_field();
        if(hovered_field == null) return null;
        hours += (Integer)hovered_field.getKey();
        day = (Integer)hovered_field.getKey();
        result = result.plusDays(day);
        return result.atTime(hours, 0);
    }
    
    private void table_update(){
        LocalDateTime time = get_selected_field_time();
        if(time == null) return;
        System.out.println(time);
    }
    
}
