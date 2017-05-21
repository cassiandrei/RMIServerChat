/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import java.util.ArrayList;

/**
 *
 * @author cassiano-ncc
 */
public class RoomChat implements IRoomChat{
    ArrayList<String> users;
    
    @Override
    public void sendMsg(String usrName, String msg) {
        
    }

    @Override
    public void joinRoom(String usrName) {
       users.add(usrName);
    }

    @Override
    public void leaveRoom(String usrName) {
        users.remove(usrName);
    }

    @Override
    public void closeRoom() {
       
    }
    
}
