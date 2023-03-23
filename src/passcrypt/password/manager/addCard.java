/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package passcrypt.password.manager;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class addCard extends javax.swing.JDialog {

    /**
     * Creates new form addCard
     */
    private boolean click_flag;
    private Connection con = null;
    private PreparedStatement pst = null;
    private Statement smt = null;
    private ResultSet rs = null;
    private String value_password, value_dbname;

    public addCard(java.awt.Frame parent, boolean modal, String pass, String dbname) {
        super(parent, modal);
        initComponents();

        value_password = pass;
        value_dbname = dbname;

        setLocationRelativeTo(null);
        password.setEchoChar('\u25cf');
        click_flag = true;
        password.setToolTipText("Double Click to Show/Hide Password !");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Credentials");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Title");

        title.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        title.setMargin(new java.awt.Insets(2, 8, 2, 8));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");

        username.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setMargin(new java.awt.Insets(2, 8, 2, 8));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");

        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setHighlighter(null);
        password.setMargin(new java.awt.Insets(2, 8, 2, 8));
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordMouseEntered(evt);
            }
        });

        save.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(username)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(title)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(exit))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String temp_pass = new String(password.getPassword()).trim();

        if ((!title.getText().trim().equals("")) && (!username.getText().trim().equals("")) && !(temp_pass.length() == 0)) {
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            createCard(value_password, value_dbname);
        } else {
            JOptionPane.showMessageDialog(PassCryptPasswordManager.obj, "All Fields are Required !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        if (click_flag) {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                password.setEchoChar((char) 0);
                click_flag = false;
            }
        } else {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                password.setEchoChar('\u25cf');
                click_flag = true;
            }
        }
    }//GEN-LAST:event_passwordMouseClicked

    private void passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseEntered
        try {
            KeyEvent ke = new KeyEvent(evt.getComponent(), KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(), InputEvent.CTRL_MASK,
                    KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
            evt.getComponent().dispatchEvent(ke);
        } catch (Throwable e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_passwordMouseEntered

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
            java.util.logging.Logger.getLogger(addCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addCard dialog = new addCard(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void createCard(String value_password, String value_dbname) {

        CardView.increaseSize();

        CardView.createCard(CardView.card_count, getNextID(value_dbname), AES256.encrypt(title.getText(), value_password), AES256.encrypt(username.getText(), value_password), AES256.encrypt(new String(password.getPassword()), value_password));
        CardView.card_container.revalidate();
        CardView.card_container.repaint();

        try {
            String url = "jdbc:sqlite:Databases/" + value_dbname + ".db";

            con = DriverManager.getConnection(url);
            String query = "INSERT into credentials (Title, Username, Password) values (?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, AES256.encrypt(title.getText(), value_password));
            pst.setString(2, AES256.encrypt(username.getText(), value_password));
            pst.setString(3, AES256.encrypt(new String(password.getPassword()), value_password));

            pst.execute();
            con.close();

            value_password = null;
            value_dbname = null;

            this.dispose();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getNextID(String value_dbname) {

        int id = 0;

        try {
            String url = "jdbc:sqlite:Databases/" + value_dbname + ".db";
            con = DriverManager.getConnection(url);

            String query = "SELECT * FROM SQLITE_SEQUENCE";
            smt = con.createStatement();
            rs = smt.executeQuery(query);

            rs.next();
            id = rs.getInt(2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                smt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
        }

        return id+1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton save;
    private javax.swing.JTextField title;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
