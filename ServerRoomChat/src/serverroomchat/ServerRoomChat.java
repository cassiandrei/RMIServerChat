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
public class ServerRoomChat implements IServerRoomChat{

    ArrayList<RoomChat> salas;
    public static void main(String[] args) {
        ServerFrame janela = new ServerFrame();
        janela.setVisible(true);
    }

    @Override
    public ArrayList<RoomChat> getRooms() {
        return salas;
    }

    @Override
    public void createRoom(String roomName) {
        RoomChat nova = new RoomChat(roomName);
        salas.add(nova);
    }
    
    
    @Override
    public void closeRoom(String nome) {
        for (int i = 0; i < salas.size(); i++) {
            RoomChat get =  salas.get(i);
            if(get.RoomName.equals(nome)){
                salas.remove(get);
            }
        }
    }
    
}
