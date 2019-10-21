/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher_security;

/**
 *
 * @author aBo ahMed
 */
public class CaesarCipher {
    
    private final int key = 3 ;
    private final int letterCount = 26;
    
    public String encrypt(String message) {
        StringBuilder result = new StringBuilder(); 

        for(int i =0;i<message.length();i++){
            char currentChar = message.charAt(i);
        
            if (Character.isUpperCase(currentChar)) { // is capital
                char ch = (char) (((int) currentChar +
                        key - 'A') % letterCount + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(currentChar)) { // is small 
                char ch = (char) (((int) currentChar +
                        key - 'a') % letterCount + 'a');
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public String decrypt(String encryptedMessage) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : encryptedMessage.toCharArray()) {
            if (Character.isUpperCase(currentChar)) {
                char ch = (char) (((int) currentChar -
                        key - 'A' + letterCount) % letterCount + 'A') ;
                result.append(ch);
            } else if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar -
                        key - 'a' + letterCount) % letterCount + 'a');
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

}
