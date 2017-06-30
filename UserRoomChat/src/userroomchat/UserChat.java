/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userroomchat;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import remoto.IUserChat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import remoto.*;

        
/**
 *
 * @author cassiano
 */
public class UserChat extends UnicastRemoteObject implements IUserChat {

    static String usrName;
    static IServerRoomChat obj;
    static Registry registry;
    public static TreeMap<String, IRoomChat> roomList;
    //static String usrChat;
    static UserFrame userFrame;
    public static String IPServer;
    

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        IPServer = JOptionPane.showInputDialog("Qual o IP do servidor?");
        try {
            registry = LocateRegistry.getRegistry(IPServer,2020);
            obj = (IServerRoomChat) registry.lookup("Servidor");
            roomList = obj.getRooms();
        } catch (Exception e) {
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
        userFrame = new UserFrame(roomList, obj, IPServer);
        userFrame.setVisible(true);
    }

    UserChat() throws RemoteException, AlreadyBoundException{
        usrName = JOptionPane.showInputDialog("Qual o nome do usuário?");
        registry.bind(usrName, this);
    }

    @Override
    public void deliverMsg(String senderName, String msg, Integer[][] clockMatrix) {
       userFrame.deliverToGUI(senderName, msg);
        System.out.println("Usuario recebeu");
    }
    
    @Override
    public void updateUserList(TreeMap<String, IUserChat> userList){
        
    }
}
