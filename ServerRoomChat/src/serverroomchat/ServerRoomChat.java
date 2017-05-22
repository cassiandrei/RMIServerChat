/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cassiano-ncc
 */
public class ServerRoomChat implements IServerRoomChat{

    ArrayList<RoomChat> salas;
    public static void main(String[] args) {
        ServerFrame janela = new ServerFrame();
        janela.setVisible(true);
        /* Qaundo cria nova sala
        String roomName = JOptionPane.showInputDialog("Qual o nome da nova sala?");
        try{
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(2020);
            r.rebind("Servidor",new RoomChat(roomName));
       }
        catch(Exception e){
            System.out.println("erro" + e);
        }*/
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
