/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import remoto.IServerRoomChat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cassiano-ncc
 */
public class ServerRoomChat implements IServerRoomChat{
    
    Registry registry;     
    String host = "localhost";
    ArrayList<RoomChat> salas;
    
    public ServerRoomChat(){
        try{
            registry = LocateRegistry.createRegistry(2020);           
            registry.rebind("Servidor", this);
        }catch(Exception e){
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        ServerRoomChat server = new ServerRoomChat();
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
            if(get.roomName.equals(nome)){
                salas.remove(get);
            }
        }
    }
    
}
