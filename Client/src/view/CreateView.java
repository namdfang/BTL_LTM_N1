/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import controller.ClientController;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Pham
 */
public class CreateView extends javax.swing.JFrame {

    /**
     * Creates new form CreateView
     */
    private String nickname;
    private ClientController cc;
    private String role;
    
    public CreateView() {
        initComponents();
    }
    
    public CreateView(String nickname, ClientController cc) {
        initComponents();
        this.setTitle(nickname);
        this.nickname = nickname;
        this.cc = cc;
        this.role = "Admin";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idroom_area = new javax.swing.JTextField();
        passroom_area = new javax.swing.JPasswordField();
        btn_create = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CREATE ROOM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Id room");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        passroom_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passroom_areaActionPerformed(evt);
            }
        });
        passroom_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passroom_areaKeyPressed(evt);
            }
        });

        btn_create.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_create.setText("Create");
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_create)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idroom_area, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(passroom_area)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idroom_area, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passroom_area, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btn_create)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passroom_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passroom_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passroom_areaActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        // TODO add your handling code here:
        this.cc.send_client_msg("Do nothing!");
        
        int room_id = Integer.parseInt(idroom_area.getText().trim());

        String room_pass = "";
        char[] pass_char = passroom_area.getPassword();
        for (char x : pass_char) {
            room_pass += x;
        }

        this.cc.send_client_msg(""+room_id);
        String msg_server = (String) cc.recv_server_msg(); // Check room id
        if (msg_server.equals("Room id existed!")) {
            idroom_area.setText("");
            passroom_area.setText("");
            idroom_area.requestFocus();
            JOptionPane.showMessageDialog(this, "Room id existed");
        }
        else if (msg_server.equals("Room id is not in range!")) {
            idroom_area.setText("");
            passroom_area.setText("");
            idroom_area.requestFocus();
            JOptionPane.showMessageDialog(this, "Room id between 40000 and 50000");
        }
        else {
            this.cc.send_client_msg(room_pass);
            this.cc.send_client_msg("Member created room!");
            msg_server = (String) cc.recv_server_msg();
            System.out.println(msg_server);
            new ChatView(this.nickname, room_id, this.cc, this.role).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_createActionPerformed

    private void passroom_areaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passroom_areaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cc.send_client_msg("Do nothing!");
        
            int room_id = Integer.parseInt(idroom_area.getText().trim());

            String room_pass = "";
            char[] pass_char = passroom_area.getPassword();
            for (char x : pass_char) {
                room_pass += x;
            }

            this.cc.send_client_msg(""+room_id);
            String msg_server = (String) cc.recv_server_msg(); // Check room id
            if (msg_server.equals("Room id existed!")) {
                idroom_area.setText("");
                passroom_area.setText("");
                idroom_area.requestFocus();
                JOptionPane.showMessageDialog(this, "Room id existed");
            }
            else if (msg_server.equals("Room id is not in range!")) {
                idroom_area.setText("");
                passroom_area.setText("");
                idroom_area.requestFocus();
                JOptionPane.showMessageDialog(this, "Room id between 40000 and 50000");
            }
            else {
                this.cc.send_client_msg(room_pass);
                this.cc.send_client_msg("Member created room!");
                msg_server = (String) cc.recv_server_msg();
                System.out.println(msg_server);
                new ChatView(this.nickname, room_id, this.cc, this.role).setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_passroom_areaKeyPressed

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
            java.util.logging.Logger.getLogger(CreateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_create;
    private javax.swing.JTextField idroom_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passroom_area;
    // End of variables declaration//GEN-END:variables
}
