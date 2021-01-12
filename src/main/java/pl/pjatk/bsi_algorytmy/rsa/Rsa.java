package pl.pjatk.bsi_algorytmy.rsa;

import pl.pjatk.bsi_algorytmy.Algorithm;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * App to encrypt/decrypt message with RSA.
 *
 * @author Filip Werra s19375
 */
public class Rsa implements Algorithm {
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();

        return pair;
    }

    /**
     *This function is genereting keys
     *
     * @return pair of keys
     * @throws Exception
     */
    public static KeyPair getKeyPairFromKeyStore() throws Exception {

        InputStream ins = Rsa.class.getResourceAsStream("/keystore.jks");

        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(ins, "s3cr3t".toCharArray());   //Keystore password
        KeyStore.PasswordProtection keyPassword =       //Key password
                new KeyStore.PasswordProtection("s3cr3t".toCharArray());

        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("mykey", keyPassword);

        java.security.cert.Certificate cert = keyStore.getCertificate("mykey");
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();

        return new KeyPair(publicKey, privateKey);
    }

    /**
     *Encrypting
     *
     * @param plainText
     * @param publicKey
     * @return encrypted message
     * @throws Exception
     */
    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));

        return Base64.getEncoder().encodeToString(cipherText);
    }

    /**
     *decrypting
     * @param cipherText
     * @param privateKey
     * @return decrypted message
     * @throws Exception
     */
    public static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);

        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        return new String(decriptCipher.doFinal(bytes), UTF_8);
    }

    /**
     * Generate sign
     *
     * @param plainText
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(UTF_8));

        byte[] signature = privateSignature.sign();

        return Base64.getEncoder().encodeToString(signature);
    }

    /**
     *Veryfing transcryption
     *
     * @param plainText
     * @param signature
     * @param publicKey
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String plainText, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes(UTF_8));

        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        return publicSignature.verify(signatureBytes);
    }

    /**
     *
     * @throws Exception
     */
    public static void main () throws Exception {
        //First generate a public/private key pair
        KeyPair pair = generateKeyPair();
        //KeyPair pair = getKeyPairFromKeyStore();

        //Our secret message
        Scanner s = new Scanner(System.in);
        System.out.println("Put message to encrypt: ");
        String message = s.nextLine();

        //Encrypt the message
        String cipherText = encrypt(message, pair.getPublic());
        System.out.println("This is encrypted message: " + cipherText);

        //Now decrypt it
        String decipheredMessage = decrypt(cipherText, pair.getPrivate());

        System.out.println(decipheredMessage);

        //Let's sign our message
        String signature = sign("foobar", pair.getPrivate());

        //Let's check the signature
        boolean isCorrect = verify("foobar", signature, pair.getPublic());
        System.out.println("Signature correct: " + isCorrect);
    }

    /**
     *
     */
    public void use(){
        try {
            main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}