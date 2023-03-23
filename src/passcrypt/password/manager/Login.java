/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package passcrypt.password.manager;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author C0delust
 */
public class Login extends javax.swing.JPanel {

    private boolean email_correct, pass_correct;
    private final String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern pattern = Pattern.compile(regex);
    private final int password_length = 6;
    private String temp_pass;
    private String url, value_email, value_password, value_dbname;

    public Login() {
        initComponents();
        email_error.setVisible(false);
        password_error.setVisible(false);
        msg.setVisible(false);
        loading.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        input_email = new javax.swing.JTextField();
        input_password = new javax.swing.JPasswordField();
        showPass = new javax.swing.JCheckBox();
        login_button = new javax.swing.JButton();
        register_label = new javax.swing.JLabel();
        forgot_password_label = new javax.swing.JLabel();
        password_error = new javax.swing.JLabel();
        email_error = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        loading = new javax.swing.JLabel();

        setFocusCycleRoot(true);
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setNextFocusableComponent(login_button);
        setPreferredSize(new java.awt.Dimension(900, 560));

        jLabel1.setFont(new java.awt.Font("Advent Pro", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setFocusCycleRoot(true);
        jLabel1.setFocusTraversalPolicyProvider(true);
        jLabel1.setNextFocusableComponent(input_email);

        input_email.setDocument(new CharacterLimit(100));
        input_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        input_email.setForeground(new java.awt.Color(153, 153, 153));
        input_email.setText("Email");
        input_email.setMargin(new java.awt.Insets(8, 10, 8, 10));
        input_email.setName(""); // NOI18N
        input_email.setNextFocusableComponent(input_password);
        input_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_emailFocusLost(evt);
            }
        });
        input_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_emailKeyReleased(evt);
            }
        });

        input_password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        input_password.setForeground(new java.awt.Color(153, 153, 153));
        input_password.setText("Master Password");
        input_password.setEchoChar((char) 0);
        input_password.setMargin(new java.awt.Insets(8, 10, 8, 10));
        input_password.setNextFocusableComponent(showPass);
        input_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_passwordFocusLost(evt);
            }
        });
        input_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                input_passwordKeyTyped(evt);
            }
        });

        showPass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        showPass.setText("Show Password");
        showPass.setNextFocusableComponent(forgot_password_label);
        showPass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showPassItemStateChanged(evt);
            }
        });

        login_button.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        login_button.setText("Login");
        login_button.setNextFocusableComponent(register_label);
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        register_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        register_label.setText("Don't have an account ? Sign Up");
        register_label.setNextFocusableComponent(input_email);
        register_label.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                register_labelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                register_labelFocusLost(evt);
            }
        });
        register_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                register_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                register_labelMouseExited(evt);
            }
        });

        forgot_password_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        forgot_password_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        forgot_password_label.setText("Forgot Password ?");
        forgot_password_label.setNextFocusableComponent(login_button);
        forgot_password_label.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                forgot_password_labelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                forgot_password_labelFocusLost(evt);
            }
        });
        forgot_password_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgot_password_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgot_password_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgot_password_labelMouseExited(evt);
            }
        });

        password_error.setBackground(new java.awt.Color(255, 255, 255));
        password_error.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        password_error.setForeground(new java.awt.Color(208, 1, 1));
        password_error.setText("Password Error");

        email_error.setBackground(new java.awt.Color(255, 255, 255));
        email_error.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        email_error.setForeground(new java.awt.Color(208, 1, 1));
        email_error.setText("Email Error");

        msg.setBackground(new java.awt.Color(255, 255, 255));
        msg.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        msg.setForeground(new java.awt.Color(26, 165, 0));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setText("User Login Successful");
        msg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 94, 4)));
        msg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passcrypt/password/manager/loading.gif"))); // NOI18N
        loading.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password_error)
                    .addComponent(email_error)
                    .addComponent(input_password)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(input_email)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(showPass)
                        .addGap(18, 18, 18)
                        .addComponent(forgot_password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(login_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(register_label, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(email_error)
                .addGap(15, 15, 15)
                .addComponent(input_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(password_error)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showPass)
                    .addComponent(forgot_password_label))
                .addGap(15, 15, 15)
                .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg)
                .addGap(7, 7, 7)
                .addComponent(register_label)
                .addGap(18, 18, 18)
                .addComponent(loading)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void input_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_input_emailFocusGained

        if (input_email.getText().equals("Email")) {
            email_correct = false;
            input_email.setText("");
            input_email.setForeground(jLabel1.getForeground());
        }
    }//GEN-LAST:event_input_emailFocusGained

    private void input_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_input_emailFocusLost
        if (input_email.getText().equals("")) {
            email_correct = false;
            input_email.setText("Email");
            input_email.setForeground(new Color(153, 153, 153));
        }

        if (!input_email.getText().equals("") && !input_email.getText().equals("Email")) {
            Matcher matcher = pattern.matcher(input_email.getText());

            if (!matcher.matches()) {
                email_error.setVisible(true);
                email_error.setText("Invalid Email");
                email_correct = false;
            } else {
                email_error.setVisible(false);
                email_correct = true;
            }
        }
    }//GEN-LAST:event_input_emailFocusLost

	private void input_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_emailKeyReleased
            if (!input_email.getText().equals("") && !input_email.getText().equals("Email")) {
                Matcher matcher = pattern.matcher(input_email.getText());

                if (!matcher.matches()) {
                    email_correct = false;
                } else {
                    email_correct = true;
                }
            } else
                email_error.setVisible(false);
    }//GEN-LAST:event_input_emailKeyReleased

    private void input_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_input_passwordFocusGained
        temp_pass = new String(input_password.getPassword());

        if (temp_pass.equals("Master Password")) {
            pass_correct = false;
            input_password.setText("");
            input_password.setForeground(jLabel1.getForeground());
        }

        temp_pass = "";
    }//GEN-LAST:event_input_passwordFocusGained

    private void input_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_input_passwordFocusLost
        temp_pass = new String(input_password.getPassword());

        if (temp_pass.equals("")) {
            pass_correct = false;
            input_password.setText("Master Password");
            input_password.setEchoChar((char) 0);
            input_password.setForeground(new Color(153, 153, 153));
        }

        if (!temp_pass.equals("") && !temp_pass.equals("Master Password")) {

            if (temp_pass.length() < password_length) {
                password_error.setVisible(true);
                password_error.setText("Password must be " + password_length + " characters or more");
                pass_correct = false;
            } else {
                password_error.setVisible(false);
                pass_correct = true;
            }
        }

        temp_pass = "";
    }//GEN-LAST:event_input_passwordFocusLost

    private void input_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_passwordKeyTyped
        showPassItemStateChanged(null);
    }//GEN-LAST:event_input_passwordKeyTyped

    private void input_passwordKeyReleased(java.awt.event.KeyEvent evt) {
        temp_pass = new String(input_password.getPassword());

        if (!temp_pass.equals("") && !temp_pass.equals("Master Password")) {
            if (temp_pass.length() < password_length) {
                pass_correct = false;
            } else {
                pass_correct = true;
            }
        } else {
            email_error.setVisible(false);
        }
    }

    private void showPassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showPassItemStateChanged
        temp_pass = new String(input_password.getPassword());

        if (!temp_pass.equals("Master Password")) {
            if (showPass.isSelected()) {
                input_password.setEchoChar((char) 0);
            } else {
                input_password.setEchoChar('\u25cf');
            }
        } else
            input_password.setEchoChar((char) 0);
    }//GEN-LAST:event_showPassItemStateChanged

    private void forgot_password_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_password_labelMouseEntered
        forgot_password_label.setFont(new java.awt.Font("Arial", 1, 12));
    }//GEN-LAST:event_forgot_password_labelMouseEntered

    private void forgot_password_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_password_labelMouseExited
        forgot_password_label.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_forgot_password_labelMouseExited

    private void forgot_password_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_password_labelMouseClicked
        PassCryptPasswordManager.obj.MainPanel.removeAll();
        PassCryptPasswordManager.obj.MainPanel.add(new forgotPass());
        PassCryptPasswordManager.obj.MainPanel.revalidate();
        PassCryptPasswordManager.obj.MainPanel.repaint();
    }//GEN-LAST:event_forgot_password_labelMouseClicked

    private void register_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_labelMouseEntered
        register_label.setFont(new java.awt.Font("Arial", 1, 12));
    }//GEN-LAST:event_register_labelMouseEntered

    private void register_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_labelMouseExited
        register_label.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_register_labelMouseExited

    private void register_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_labelMouseClicked
        PassCryptPasswordManager.obj.MainPanel.removeAll();
        PassCryptPasswordManager.obj.MainPanel.add(new Register());
        PassCryptPasswordManager.obj.MainPanel.revalidate();
        PassCryptPasswordManager.obj.MainPanel.repaint();
    }//GEN-LAST:event_register_labelMouseClicked

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        if (email_correct && pass_correct) {
            if (new File("Databases\\users.db").exists()) {
                initLogin();
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Users Database not Found !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setMsg(msg, " Enter Email and Master Password ", "RED", 2);
        }
    }//GEN-LAST:event_login_buttonActionPerformed

    private void forgot_password_labelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forgot_password_labelFocusGained
        forgot_password_label.setFont(new java.awt.Font("Arial", 1, 12));
    }//GEN-LAST:event_forgot_password_labelFocusGained

    private void forgot_password_labelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forgot_password_labelFocusLost
        forgot_password_label.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_forgot_password_labelFocusLost

    private void register_labelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_labelFocusGained
        register_label.setFont(new java.awt.Font("Arial", 1, 12));
    }//GEN-LAST:event_register_labelFocusGained

    private void register_labelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_labelFocusLost
        register_label.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_register_labelFocusLost

    public void initLogin() {
        value_email = MD5Hash.getMd5(input_email.getText());
        value_password = MD5Hash.getMd5(new String(input_password.getPassword()));
        url = "jdbc:sqlite:Databases/users.db";
        loading.setVisible(true);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                loginUser();
            }
        },
                50
        );
    }

    public void loginUser() {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            con = DriverManager.getConnection(url);

            String query = "SELECT emailid, password,dbname, temp FROM users WHERE emailid = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, value_email);
            rs = pst.executeQuery();

            if (rs.next()) {
                query = "SELECT emailid, password, dbname, temp FROM users WHERE emailid = ? AND password = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, value_email);
                pst.setString(2, value_password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    value_password = new String(input_password.getPassword());
                    value_dbname = rs.getString("dbname");

                    if (new File("Databases\\" + value_dbname + ".db").exists()) {
                        PassCryptPasswordManager.obj.MainPanel.removeAll();
                        PassCryptPasswordManager.obj.MainPanel.add(new CardView(value_password, value_dbname));
                        PassCryptPasswordManager.obj.MainPanel.revalidate();
                        PassCryptPasswordManager.obj.MainPanel.repaint();
                    } else {
                        java.awt.Toolkit.getDefaultToolkit().beep();
                        loading.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Database not Found !", "Error", JOptionPane.ERROR_MESSAGE);        
                    }

                } else {
                    setMsg(msg, " Invalid Password ! ", "RED", 2);
                    input_password.setText("");
                    input_password.requestFocus();
                    login_button.requestFocus();
                    loading.setVisible(false);
                }
            } else {
                setMsg(msg, " Invalid Email ! ", "RED", 2);
                input_password.setText("");
                input_password.requestFocus();
                login_button.requestFocus();
                loading.setVisible(false);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    private void setMsg(JLabel label, String text, String color, int timeout) {
        if (color.equals("RED")) {
            label.setForeground(new Color(255, 36, 0));
            label.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 36, 0)));
        } else if (color.equals("GREEN")) {
            label.setForeground(new Color(26, 165, 0));
            label.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 94, 4)));
        }

        label.setText(text);
        label.setVisible(true);

        if (timeout > 0) {
            timeout = timeout * 1000;

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                @Override
                public void run() {
                    label.setVisible(false);
                }
            },
                    timeout
            );
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email_error;
    private javax.swing.JLabel forgot_password_label;
    private javax.swing.JTextField input_email;
    private javax.swing.JPasswordField input_password;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loading;
    private javax.swing.JButton login_button;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel password_error;
    private javax.swing.JLabel register_label;
    private javax.swing.JCheckBox showPass;
    // End of variables declaration//GEN-END:variables

}
