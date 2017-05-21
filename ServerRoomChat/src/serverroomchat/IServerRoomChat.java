/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverroomchat;

import java.rmi.RemoteException;
import java.rmi.Remote;

import java.util.ArrayList;
/**
 *
 * @author cassiano
 */
public interface IServerRoomChat extends Remote{
    public ArrayList<RoomChat> getRooms() throws RemoteException;
    public void createRoom(String roomName) throws RemoteException;
    public void closeRoom() throws RemoteException;
}
