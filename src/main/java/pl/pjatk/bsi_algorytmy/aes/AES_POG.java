package pl.pjatk.bsi_algorytmy.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
/**
 * Java implementation of AES algorithm.
 *
 * @author Filip Magdziak s19616
 */
public class AES_POG {

    private static SecretKeySpec secretKey;
    private static byte[] key;
    //method creating secret key from given myKey
    public static void setKey(String myKey)
    {
        MessageDigest sha = null; //initialization
        try {
            key = myKey.getBytes("UTF-8"); //encoding String into a sequence of bytes
            sha = MessageDigest.getInstance("SHA-1"); // Returns a MessageDigest object that implements the specified digest algorithm
            key = sha.digest(key); //Completes the hash computation by performing final operations
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES"); //constructs a secret key from the given byte array
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    //method to encrypt given message using AES
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret); //calling method we previously implemented
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); //Returns a Cipher object that implements the specified transformation
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // initializes the cipher with a key
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))); //returns encrypted message
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    //method to decrypt given encrypted message in AES
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); //Returns a Cipher object that implements the specified transformation
            cipher.init(Cipher.DECRYPT_MODE, secretKey); //decrypts the message
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))); //returns decrypted message
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
