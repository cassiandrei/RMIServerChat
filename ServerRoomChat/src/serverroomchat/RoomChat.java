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
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import remoto.IRoomChat;
import static serverroomchat.ServerRoomChat.salas;

/**
 *
 * @author cassiano-ncc
 */
public class RoomChat extends UnicastRemoteObject implements IRoomChat {

    // ArrayList<String> users = new ArrayList<String>();
    String roomName;
    static IUserChat obj;
    //private HashMap<String, IUserChat> users = new HashMap<>();
    private TreeMap userList = new TreeMap();

    RoomChat(String nome) throws RemoteException {
        roomName = nome;
    }

    @Override
    public void sendMsg(String usrName, String msg) {
        this.users.entrySet().forEach((user) -> {
            try {
                user.getValue().deliverMsg(usrName,msg);
               // obj = (IUserChat) registry.lookup(usrName);
                //obj.deliverMsg(usrName, msg);
            } catch (RemoteException e) {
                System.out.println("erro:" + e);
            }
        });
    }

    @Override
    public void joinRoom(String usrName) throws RemoteException, AccessException {
        System.out.println("USUARIO:");
        Registry registry = LocateRegistry.getRegistry(2020);
        try {
            IUserChat user = (IUserChat) registry.lookup(usrName);
            users.put(usrName, user);
        } catch (NotBoundException ex) {
            Logger.getLogger(RoomChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Entrou");
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
            if (salas.get(i).equals(nome)) {
                salas.remove(i);
            }
        }
    }
}
