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

    String usrName;
    static IRemoto obj;
    static Registry registry;
    static ArrayList<Object> rooms;
    
    public static void main(String[] args) {
        JOptionPane.showInputDialog("Qual o IP do servidor?");
        try {
            registry = LocateRegistry.getRegistry("Servidor", 2020);
            obj = (IRemoto) registry.lookup("getRooms");
            rooms = obj.getRooms();
        } catch (Exception e) {
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
    }



    @Override
        public void deliverMsg(String senderName, String msg) {
       
    }
    
}
