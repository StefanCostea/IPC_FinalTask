/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxmlapplication;
import model.Member;

/**
 *
 * @author stefancostea
 */
public class CurrentUser {
    private static Member current_user;

    private CurrentUser() {}
    
    public static void setInstance(Member member){
        current_user = member;
    }
    
    public static Member getInstace(){
        return current_user;
    }
    
}
