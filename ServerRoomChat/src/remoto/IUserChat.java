/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.rmi.RemoteException;
import java.util.TreeMap;

/**
 *
 * @author cassiano
 */ 
public interface IUserChat extends java.rmi.Remote{
    public void deliverMsg(String senderName, String msg, Integer[][] clockMatrix) throws RemoteException;
    public void updateUserList(TreeMap<String, IUserChat> userList) throws RemoteException;
}
