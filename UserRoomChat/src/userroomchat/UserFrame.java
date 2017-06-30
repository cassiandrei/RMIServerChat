/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userroomchat;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import remoto.IServerRoomChat;
import javax.swing.JOptionPane;
import remoto.IRoomChat;
import remoto.IUserChat;
import static userroomchat.UserChat.IPServer;
import static userroomchat.UserChat.obj;

/**
 *
 * @author Arthur
 */
public class UserFrame extends javax.swing.JFrame {

    public TreeMap<String, IRoomChat> roomList;
    public IServerRoomChat iServer;
    public IUserChat iUsr;
    public IRoomChat iRoom;
    public ArrayList<IRoomChat> objRooms = new ArrayList<IRoomChat>();
    public UserChat usr;
    static Registry registry;
    public String IPServer;
    public String usrChat;
    IRoomChat room=null;

    public UserFrame(TreeMap<String, IRoomChat> roomList, IServerRoomChat iServer, String IPServer) throws RemoteException, AlreadyBoundException {
        this.usr = new UserChat();
        this.roomList = roomList;
        this.iServer = iServer;
        this.IPServer = IPServer;
        initComponents();
        if (roomList != null) {
            for (String roomNames1 : roomList.keySet()) { // adiciono a lista de salas para o jComboBox
                listaSalas.addItem(roomNames1);
            }
        }
    }

    public UserFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaSalas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        userJoinButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        newMsg = new javax.swing.JTextArea();
        usrSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lista de Salas");

        userJoinButton.setText("Join");
        userJoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJoin(evt);
            }
        });

        jButton2.setText("Create Room");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCreateRoom(evt);
            }
        });

        chat.setEditable(false);
        chat.setColumns(20);
        chat.setRows(5);
        jScrollPane1.setViewportView(chat);

        jLabel2.setText("Chat");

        newMsg.setColumns(20);
        newMsg.setRows(5);
        jScrollPane2.setViewportView(newMsg);

        usrSend.setText("Send");
        usrSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSend(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel2)))
                .addContainerGap(298, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaSalas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(userJoinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usrSend)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userJoinButton))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(usrSend)
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userJoin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJoin
        if (roomList.size() > 0) {
            Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(2020);
                this.room = (IRoomChat) registry.lookup((String)listaSalas.getSelectedItem());
                System.out.println("USER: "+ usr.usrName);
                room.joinRoom((String)usr.usrName,iUsr);
                objRooms.add(room);
                //deliverToGUI(usrChat);
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_userJoin

    private void userCreateRoom(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCreateRoom
        String roomName = JOptionPane.showInputDialog("Qual o nome da nova sala?");
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(2020);
            //usr = new UserChat();
            //registry.bind(usr.usrName, this.usr);
            iServer.createRoom(roomName);
            roomList.put(roomName,iRoom);
            //deliverToGUI(usrChat);
        } catch (RemoteException ex) {
            Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_userCreateRoom

    private void userSend(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSend
         try {
            registry = LocateRegistry.getRegistry(2020); // host do user ao invés de IPServer
            this.room = (IRoomChat) registry.lookup((String)listaSalas.getSelectedItem());
            //this.room.sendMsg(usr.usrName, newMsg.getText());
            newMsg.removeAll();
        } catch (NotBoundException | RemoteException e) {
            System.out.println("erro:" + e);
        }
    }//GEN-LAST:event_userSend

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserFrame().setVisible(true);

            }
        });
    }

    public void deliverToGUI(String senderUsrName, String msg) {
        chat.removeAll();
        chat.insert(senderUsrName + ": " + msg + "\n",0);
        listaSalas.removeAllItems();
        if (roomList != null) {
            for (String roomNames1 : roomList.keySet()) { // adiciono a lista de salas para o jComboBox
                listaSalas.addItem(roomNames1);
            }
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chat;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listaSalas;
    private javax.swing.JTextArea newMsg;
    private javax.swing.JButton userJoinButton;
    private javax.swing.JButton usrSend;
    // End of variables declaration//GEN-END:variables
}
