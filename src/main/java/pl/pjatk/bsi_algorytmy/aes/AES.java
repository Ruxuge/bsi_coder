package pl.pjatk.bsi_algorytmy.aes;

import pl.pjatk.bsi_algorytmy.Algorithm;
/**
 * This class is hashing text from user.
 * To Hash text program is using salting. All salt is generate in salt().
 * All data is save in saltFile.out
 *
 * @author Filip Magdziak s19616
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 * App to encrypt and decrypt any String message using AES.
 *
 * @author Filip Magdziak s19616
 */
public class AES implements Algorithm{
    public static void main(String[] args)
    {
        final String secretKey = "ssshhhhhhhhhhh!!";
        Scanner pog = new Scanner(System.in);
        String originalString = pog.nextLine();
        String encryptedString = AES_POG.encrypt(originalString, secretKey) ;
        String decryptedString = AES_POG.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
    String[] avs = {"1"};
    public void use(){
        try{
            main(avs);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}