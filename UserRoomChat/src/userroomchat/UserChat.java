/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userroomchat;

import remoto.IUserChat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import remoto.*;

        
/**
 *
 * @author cassiano
 */
public class UserChat implements IUserChat {

    static String usrName;
    static IServerRoomChat obj;
    static Registry registry;
    public static ArrayList<String> roomList;
    static String usrChat;
    static UserFrame userFrame;
    public static String IPServer;
    
    UserChat(String nome) {
        usrName = nome;
    }

    public static void main(String[] args) {
        IPServer = JOptionPane.showInputDialog("Qual o IP do servidor?");
        try {
            registry = LocateRegistry.getRegistry(IPServer, 2020);
            obj = (IServerRoomChat) registry.lookup("Servidor");
            roomList = obj.getRooms();
        } catch (Exception e) {
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
        userFrame = new UserFrame(roomList,usrName, usrChat, obj, IPServer);
        userFrame.setVisible(true);
    }

    @Override
    public void deliverMsg(String senderName, String msg) {
       usrChat = usrChat + senderName + ": " + msg + "\n";
       userFrame.atualizaChat(usrChat);
       userFrame.atualiza();

    }

}
