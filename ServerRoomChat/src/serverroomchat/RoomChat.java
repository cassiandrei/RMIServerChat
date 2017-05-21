/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import remoto.IRemoto;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cassiano-ncc
 */
public class RoomChat implements IRoomChat{
    String RoomName;
    ArrayList<Users> users;
    String roomName;
    static IRemoto obj;
    
    RoomChat(String nome){
        RoomName = nome;
    }
    
    @Override
    public void sendMsg(String usrName, String msg) {
        for (int i = 0; i < users.size(); i++) {
            Registry registry;
            String destino = users.get(i).host;
            try {
                registry = LocateRegistry.getRegistry(destino,2020);
                obj = (IRemoto) registry.lookup("deliveryMsg");
                obj.deliverMsg(usrName, msg);
            }catch(Exception e){
                    System.out.println("erro:" + e);
                    e.printStackTrace();
            }
        }
    }

    @Override
    public void joinRoom(String usrName, String host) {
       Users usuario = new Users(usrName, host);
       users.add(usuario);
    }

    @Override
    public void leaveRoom(String usrName) {
        for (int i = 0; i < users.size(); i++) {
            Users get =  users.get(i);
            if(get.name.equals(usrName)){
                users.remove(get);
            }
        }
    }
}
