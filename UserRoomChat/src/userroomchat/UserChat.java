/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userroomchat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import remoto.IRemoto;

/**
 *
 * @author cassiano
 */
public class UserChat implements IUserChat {

    static String usrName;
    static IRemoto obj;
    static Registry registry;
    public static ArrayList<Object> rooms;
    public static ArrayList<String> roomNames;
    static String usrChat;
    static UserFrame userFrame;
    
    UserChat(String nome) {
        usrName = nome;
    }

    public static void main(String[] args) {
        String IPServer = JOptionPane.showInputDialog("Qual o IP do servidor?");
        try {
            registry = LocateRegistry.getRegistry(IPServer, 2020);
            obj = (IRemoto) registry.lookup("Servidor");
            rooms = obj.getRooms();
            roomNames = obj.getRoomNames();
        } catch (Exception e) {
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
        userFrame = new UserFrame(rooms,usrName,roomNames, usrChat, obj);
        userFrame.setVisible(true);
    }

    @Override
    public void deliverMsg(String senderName, String msg) {
       userFrame.setVisible(false);
       usrChat = usrChat + senderName + ": " + msg + "\n";
       userFrame = new UserFrame(rooms,usrName,roomNames, usrChat, obj);
       userFrame.atualiza();
       userFrame.setVisible(true);
    }

}
