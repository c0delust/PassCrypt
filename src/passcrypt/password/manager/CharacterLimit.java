/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passcrypt.password.manager;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author C0delust
 */
public class CharacterLimit extends PlainDocument{

    private int limit;
    CharacterLimit(int limit) 
    {
        super();
        this.limit = limit;
    }

    CharacterLimit(int limit, boolean upper) 
    {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException 
    {
        if (str == null)
            return;

         if ((getLength() + str.length()) <= limit) 
        {
            super.insertString(offset, str, attr);
        }
    }
}
