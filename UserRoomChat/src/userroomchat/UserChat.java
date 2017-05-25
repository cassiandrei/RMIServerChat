/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userroomchat;

import java.rmi.RemoteException;
import remoto.IUserChat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
    public static ArrayList<String> roomList;
    static String usrChat;
    static UserFrame userFrame;
    public static String IPServer;
    

    public static void main(String[] args) {
        IPServer = JOptionPane.showInputDialog("Qual o IP do servidor?");
        
        try {
            registry = LocateRegistry.getRegistry(2020);
            obj = (IServerRoomChat) registry.lookup("Servidor");
            roomList = obj.getRooms();
        } catch (Exception e) {
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
        userFrame = new UserFrame(roomList, obj, IPServer);
        userFrame.setVisible(true);
    }

    UserChat() throws RemoteException{
        usrName = JOptionPane.showInputDialog("Qual o nome do usuário?");

    }

    @Override
    public void deliverMsg(String senderName, String msg) {
       usrChat = usrChat + senderName + ": " + msg + "\n";
       userFrame.atualizaChat(usrChat);
       userFrame.atualiza();

    }

}
