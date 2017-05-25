/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import java.rmi.RemoteException;
import remoto.IServerRoomChat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cassiano-ncc
 */
public class ServerRoomChat extends UnicastRemoteObject implements IServerRoomChat{
    
    Registry registry;     
    String host = "localhost";
    static ArrayList<String> salas = new ArrayList<String>();
    static ServerFrame srvFrame;
    
    public ServerRoomChat() throws RemoteException{
        super();
        try{
            registry = LocateRegistry.createRegistry(2020);           
            registry.rebind("Servidor", this);
            System.out.println("Servidor criado!");
        }catch(Exception e){
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) throws RemoteException {
        ServerRoomChat server = new ServerRoomChat();
        srvFrame = new ServerFrame(salas);
        srvFrame.setVisible(true);
    }

    @Override
    public ArrayList<String> getRooms() {
        return salas;
    }

    @Override
    public void createRoom(String roomName) {
        salas.add(roomName);
        System.out.println("Sala Criada:" + roomName);
        srvFrame.atualiza();
    }
   
    
}