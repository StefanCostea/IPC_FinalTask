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
    private Member current_user;

    private CurrentUser() {}
    
    public void setInstance(Member member){
        current_user = member;
    }
    
    public Member getInstace(){
        return current_user;
    }
    
}
