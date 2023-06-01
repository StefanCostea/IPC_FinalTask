/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import com.sun.javafx.geom.Vec2d;
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
import javafx.beans.property.BooleanProperty;
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
    
    @FXML
    private DatePicker date_picker;
    
    private boolean hovered_fields[][];
    
    LocalDate monday_of_the_week;
    
   
    /**
     * Initializes the controller class.
     */
    
    
    public MainpageController() {
        hovered_fields = new boolean[5][13];
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        field_table_view.visibleProperty().bind(field_gridpane.hoverProperty());
        field_table_view.visibleProperty().addListener(e->{
            table_update();
        });
        for(Node e : field_gridpane.getChildren()){
            e.hoverProperty().addListener(o->{
                hovered_fields[GridPane.getColumnIndex(e)-1][GridPane.getRowIndex(e)-1] = e.hoverProperty().get();
            });
        }
    }

    private Vec2d get_hovered_field(){
        for(int i = 0; i<hovered_fields.length; i++){
            for(int j = 0; j<hovered_fields.length;j++){
                if(hovered_fields[i][j]) return new Vec2d(i,j);
            }
        }
        return null;
    }

    @FXML
    private void date_selected(ActionEvent event) {
        LocalDate selectedDate = date_picker.getValue();
        monday_of_the_week = selectedDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
    
    private LocalDate get_selected_field_time(){
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
        
        Vec2d hovered_field = get_hovered_field();
        if(hovered_field == null) return null;
        hours += hovered_field.y;
        day = (int)hovered_field.x;
        result.plusDays(day);
        result.atTime(hours, 0);
        return result;
    }
    
    private void table_update(){
        LocalDate time = get_selected_field_time();
        if(time == null) return;
        System.out.println(time);
    }
    
}
