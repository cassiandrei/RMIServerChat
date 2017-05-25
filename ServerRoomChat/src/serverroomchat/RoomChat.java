/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import remoto.*;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import remoto.IRoomChat;
import static serverroomchat.ServerRoomChat.salas;

/**
 *
 * @author cassiano-ncc
 */
public class RoomChat extends UnicastRemoteObject implements IRoomChat{
    ArrayList<String> users;
    String roomName;
    static IUserChat obj;
    
    RoomChat(String nome) throws RemoteException{
        roomName = nome;
    }
    
    @Override
    public void sendMsg(String usrName, String msg) {
        /*for (int i = 0; i < users.size(); i++) {
            Registry registry;
            try {
                //registry = LocateRegistry.getRegistry(destino,2020);
                obj = (IUserChat) registry.lookup("deliveryMsg");
                obj.deliverMsg(usrName, msg);
            }catch(Exception e){
                    System.out.println("erro:" + e);
                    e.printStackTrace();
            }
        }*/
    }

    @Override
    public void joinRoom(String usrName) {
       users.add(usrName);
    }

    @Override
    public void leaveRoom(String usrName) {
      /*  for (int i = 0; i < users.size(); i++) {
            Users get =  users.get(i);
            if(get.name.equals(usrName)){
                users.remove(get);
            }
        }*/
    }
    
    @Override
    public void closeRoom(String nome) {
        for (int i = 0; i < salas.size(); i++) {
            if(salas.get(i).equals(nome)){
                salas.remove(i);
            }
        }
    }
}
