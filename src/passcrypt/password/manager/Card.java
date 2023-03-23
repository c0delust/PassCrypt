package passcrypt.password.manager;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import passcrypt.password.manager.MainWindow;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author C0delust
 */
public class Card extends javax.swing.JPanel {

    private int index;
    private String id_value;
    private String title_value;
    private String username_value;
    private String password_value;
    private String dbname_value;
    private CardView cv;
    private boolean click_flag;
    private CardView cred_view;
    private String temp[] = new String[3];
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pst = null;

    public Card(int index, String v1, String v2, String v3, String v4, String v5) {
        initComponents();
        index = this.index;
        id_value = v1;
        title_value = v2;
        username_value = v3;
        password_value = v4;
        dbname_value = v5;
        click_flag = true;
        title.setText(title_value);
        username.setText(username_value);
        password.setText(password_value);
        password.setToolTipText("Double Click to Show/Hide & Copy Password !");
        title.setEditable(false);
        username.setEditable(false);
        password.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(1, 122, 180), null, null));
        setMaximumSize(new java.awt.Dimension(230, 190));
        setMinimumSize(new java.awt.Dimension(230, 190));

        title.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        title.setToolTipText("");
        title.setMargin(new java.awt.Insets(2, 8, 2, 8));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Title");

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
        password.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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

        edit.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edit)
                    .addComponent(delete))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        String temp_pass = new String(password.getPassword()).trim();

        if (delete.getText().equals("Delete")) {
            int res = JOptionPane.showConfirmDialog(PassCryptPasswordManager.obj, "Are you sure you want to delete this Credentials ?", "PassCrypt - Password Manager", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.YES_OPTION) {
                deleteRow();
                this.setVisible(false);
                CardView.deleteCard(index);
            }
        } else {

            setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(1, 122, 180), null, null));
            password.setEchoChar('\u25cf');

            title.setText(temp[0]);
            username.setText(temp[1]);
            password.setText(temp[2]);
            edit.setText("Edit");
            delete.setText("Delete");
            title.setEditable(false);
            username.setEditable(false);
            password.setEditable(false);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (click_flag) {

                password.setEchoChar((char) 0);

                if (!password.isEditable()) {

                    StringSelection stringSelection = new StringSelection(new String(password.getPassword()).trim());
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                    password.setToolTipText("Password Copied !");

                    try {
                        KeyEvent ke = new KeyEvent(evt.getComponent(), KeyEvent.KEY_PRESSED,
                                System.currentTimeMillis(), InputEvent.CTRL_MASK,
                                KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
                        evt.getComponent().dispatchEvent(ke);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                        @Override
                        public void run() {
                            password.setToolTipText("Double Click to Show/Hide & Copy Password !");
                            password.setEchoChar('\u25cf');
                            click_flag = true;
                        }
                    },
                            3000
                    );
                }

                click_flag = false;
            } else {
                password.setToolTipText("Double Click to Show/Hide & Copy Password !");
                password.setEchoChar('\u25cf');
                click_flag = true;
            }
        }
    }//GEN-LAST:event_passwordMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 36, 0), null, null));

        String temp_pass = new String(password.getPassword()).trim();

        if ((!title.getText().trim().equals("")) && (!username.getText().trim().equals("")) && !(temp_pass.length() == 0)) {
            {
                if (edit.getText().equals("Edit")) {
                    temp[0] = title.getText();
                    temp[1] = username.getText();
                    temp[2] = new String(password.getPassword());
                    edit.setText("Save");
                    delete.setText("Cancel");
                    title.setEditable(true);
                    username.setEditable(true);
                    password.setEditable(true);
                } else {
                    updateRow();

                    setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(1, 122, 180), null, null));
                }
            }

        } else {
            JOptionPane.showMessageDialog(PassCryptPasswordManager.obj, "All Fields are Required !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseEntered
        if (password.isEditable()) {
            password.setToolTipText("Double Click to Show/Hide Password !");
        } else {
            password.setToolTipText("Double Click to Show/Hide & Copy Password !");
            try {
                KeyEvent ke = new KeyEvent(evt.getComponent(), KeyEvent.KEY_PRESSED,
                        System.currentTimeMillis(), InputEvent.CTRL_MASK,
                        KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
                evt.getComponent().dispatchEvent(ke);
            } catch (Throwable e1) {
                e1.printStackTrace();
            }
        }

    }//GEN-LAST:event_passwordMouseEntered

    public void updateRow() {
        con = null;
        pst = null;

        try {
            String url = "jdbc:sqlite:Databases/" + dbname_value + ".db";

            con = DriverManager.getConnection(url);
            String query = "UPDATE credentials SET Title = ?, Username = ?, Password = ? WHERE ID = " + id_value;
            pst = con.prepareStatement(query);
            pst.setString(1, AES256.encrypt(title.getText(), CardView.value_password));
            pst.setString(2, AES256.encrypt(username.getText(), CardView.value_password));
            pst.setString(3, AES256.encrypt(new String(password.getPassword()), CardView.value_password));

            pst.execute();

            title.setEditable(false);
            username.setEditable(false);
            password.setEditable(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                pst.close();
                con.close();

                edit.setText("Edit");
                delete.setText("Delete");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteRow() {

        try {
            String url = "jdbc:sqlite:Databases/" + dbname_value + ".db";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            String query = "DELETE FROM credentials WHERE ID = " + id_value;
            stmt.executeUpdate(query);

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField title;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
