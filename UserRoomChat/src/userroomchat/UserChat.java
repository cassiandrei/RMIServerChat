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
    static IServerRoomChat iServer;
    static Registry registry;
    public static TreeMap<String, IRoomChat> roomList;
    public TreeMap<String, IUserChat> userList;
    public Integer ID = null;
    static UserFrame userFrame;
    public static String IPServer;
    ArrayList<MsgBuffer> buffer = new ArrayList();
    Integer[][] clockMatrix = new Integer[20][20];

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        IPServer = JOptionPane.showInputDialog("Qual o IP do servidor?");
        try {
            registry = LocateRegistry.getRegistry(IPServer, 2020);
            iServer = (IServerRoomChat) registry.lookup("Servidor");
            roomList = iServer.getRooms();
        } catch (Exception e) {
            System.out.println("erro:" + e);
            e.printStackTrace();
        }
        userFrame = new UserFrame(roomList, iServer, IPServer);
        userFrame.setVisible(true);
    }

    UserChat() throws RemoteException, AlreadyBoundException {
        usrName = JOptionPane.showInputDialog("Qual o nome do usuário?");
        registry.bind(usrName, this);
    }

    @Override
    public void deliverMsg(String senderName, String msg, int id, Integer[] clockMatrix) {
        this.clockMatrix[id] = clockMatrix;
        this.clockMatrix[this.ID][id]++;
        buffer.add(new MsgBuffer(id, this.clockMatrix[this.ID][id], senderName, msg));
        int cont = 0;
        for (int i = 0; i < clockMatrix.length; i++) {
            if (this.clockMatrix[id][i] > this.clockMatrix[this.ID][i]) {
                cont++;
            }
        }
        //System.out.println("cont = " + cont);
        while (cont > 0) {
            //System.out.println("Usuario recebeu");           
            cont = 0;
            for (int i = 0; i < clockMatrix.length; i++) {
                if (this.clockMatrix[id][i] > this.clockMatrix[this.ID][i]) {
                    cont++;
                }
            }
        }
        userFrame.deliverToGUI(senderName, msg);
        for (int j = 0; j < clockMatrix.length; j++) {
            cont=0;
            for (int i = 0; i < clockMatrix.length; i++) {
                if (this.clockMatrix[i][j] != null) {
                    if (this.clockMatrix[i][j] < menorIDMsgBuffer(j)) {
                        cont++;
                    }
                }
            }
            if(cont == 0){
                //tira do buffer a mensagem do idSender j
                for(int k=0;k<buffer.size();k++){
                    if(buffer.get(k).idSender == j && buffer.get(k).idMsg == menorIDMsgBuffer(j)){
                        buffer.remove(k);
                    }
                }
            }
        }
        System.out.println("Buffer de " + this.usrName + ": ");
        for (int i = 0; i < buffer.size(); i++) {
            System.out.println(buffer.get(i).msg);
        }
    }

    @Override
    public void updateUserList(TreeMap<String, IUserChat> userList) {
        while (!buffer.isEmpty()) {

        }
        if (this.ID != null) {
            System.out.println("ID: " + this.ID);
            for (int i = 0; i < this.clockMatrix.length; i++) {
                this.clockMatrix[this.ID][i] = 0;
            }
        }
        this.userList = userList;
    }

    public int getID() {
        return this.ID;
    }

    public int menorIDMsgBuffer(int idSender) {
        int menorID = Integer.MAX_VALUE;
        for (int i = 0; i < this.buffer.size(); i++) {
            if (buffer.get(i).idSender == idSender) {
                if (buffer.get(i).idMsg < menorID) {
                    menorID = buffer.get(i).idMsg;
                }
            }
        }
        if(menorID == Integer.MAX_VALUE){
            return -1;
        }
        else return menorID;
    }
}
