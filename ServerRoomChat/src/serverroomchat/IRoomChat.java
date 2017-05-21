/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface IRoomChat extends Remote{
    public void sendMsg(String usrName, String msg) throws RemoteException;
    public void joinRoom(String usrName, String host) throws RemoteException;
    public void leaveRoom(String usrName) throws RemoteException;
    public void closeRoom() throws RemoteException;
}
