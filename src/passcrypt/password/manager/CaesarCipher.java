/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passcrypt.password.manager;

import java.awt.List;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author C0delust
 */
public class CaesarCipher {

    public static void main(String args[]) {

    }

    public static String encrypt_shuffle(String text) {

        text = text.replaceAll("[\\.0123456789_-]", "D");
        text = text.replaceAll("[+~]", "");
        text = text.toLowerCase();

        StringBuffer result = new StringBuffer();
        int shift = new Random().nextInt(10);

        //Encryption
        while (shift == 0) {
            shift = new Random().nextInt(20);
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
            result.append(ch);
        }

        //Shuffle
        StringBuilder output = new StringBuilder(new String(result).length());

        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c : new String(result).toCharArray()) {
            characters.add(c);
        }
        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }

        return new String(output);
    }

    public static StringBuffer encrypt(String text) {
        StringBuffer result = new StringBuffer();
        int shift = new Random().nextInt(10);

        while (shift == 0) {
            shift = new Random().nextInt(10);
        }

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}
