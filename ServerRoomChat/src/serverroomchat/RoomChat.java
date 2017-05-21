/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;



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
    ArrayList<String> users;
    ArrayList<String> host;
    static Iremoto obj;
    @Override
    public void sendMsg(String usrName, String msg) {
        for (int i = 0; i < users.size(); i++) {
            String usuario = users.get(i);
            String destino = host.get(i);
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry(destino,2020);
                obj = (deliveryMsg) registry.lookup("deliveryMsg");
                = obj.;
            }catch(Exception e){
                    System.out.println("erro:" + e);
                    e.printStackTrace();
            }   
        }
    }

    @Override
    public void joinRoom(String usrName, String host) {
       users.add(usrName);
       this.host.add(host);
    }

    @Override
    public void leaveRoom(String usrName) {
        users.remove(usrName);
    }

    @Override
    public void closeRoom() {
       
    }
    
}
