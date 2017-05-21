/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author cassiano
 */
public interface IRemoto {
    public void sendMsg(String usrName, String msg) throws RemoteException;
    public void joinRoom(String usrName, String host) throws RemoteException;
    public void leaveRoom(String usrName) throws RemoteException;
    public void closeRoom() throws RemoteException;
    public ArrayList<RoomChat> getRooms() throws RemoteException;
    public void createRoom(String roomName) throws RemoteException;
    public void deliverMsg(String senderName, String msg) throws RemoteException;     
}
