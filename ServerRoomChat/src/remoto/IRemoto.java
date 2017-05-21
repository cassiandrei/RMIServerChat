/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import serverroomchat.RoomChat;

/**
 *
 * @author cassiano
 */
public interface IRemoto extends Remote {
    public void deliverMsg(String senderName, String msg) throws RemoteException;  
}
