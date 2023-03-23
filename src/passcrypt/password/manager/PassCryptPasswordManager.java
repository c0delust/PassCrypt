/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passcrypt.password.manager;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import javax.swing.JFrame;

public class PassCryptPasswordManager {

    public static MainWindow obj;

    public static void main(String args[]) {
        FlatArcDarkContrastIJTheme.setup();
        obj = new MainWindow();
        obj.setVisible(true);
        
        obj.setLocationRelativeTo(null);
    }
}
