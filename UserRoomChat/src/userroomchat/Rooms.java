/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userroomchat;

import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class Rooms {
    ArrayList<Object> users;
    String name;
    
    Rooms(String name, ArrayList<Object> users){
        this.users = users;
        this.name = name;
    }
}
