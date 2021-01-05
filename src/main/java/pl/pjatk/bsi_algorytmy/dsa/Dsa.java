package pl.pjatk.bsi_algorytmy.dsa;

import pl.pjatk.bsi_algorytmy.Algorithm;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Scanner;
import java.util.Base64;


public class Dsa implements Algorithm{

    // Signing Algorithm
    private static final String
            SIGNING_ALGORITHM
            = "SHA256withRSA";
    private static final String RSA = "RSA";
    public static Scanner sc;

    // Function to implement Digital signature
    // using SHA256 and RSA algorithm
    // by passing private key.
    public static byte[] Create_Digital_Signature(
            byte[] input,
            PrivateKey Key)
            throws Exception
    {
        Signature signature
                = Signature.getInstance(
                SIGNING_ALGORITHM);
        signature.initSign(Key);
        signature.update(input);
        return signature.sign();
    }

    // Generating the asymmetric key pair
    // using SecureRandom class
    // functions and RSA algorithm.
    public static KeyPair Generate_RSA_KeyPair()
            throws Exception
    {
        SecureRandom secureRandom
                = new SecureRandom();
        KeyPairGenerator keyPairGenerator
                = KeyPairGenerator
                .getInstance(RSA);
        keyPairGenerator
                .initialize(
                        2048, secureRandom);
        return keyPairGenerator
                .generateKeyPair();
    }

    // Function for Verification of the
    // digital signature by using the public key
    public static boolean
    Verify_Digital_Signature(
            byte[] input,
            byte[] signatureToVerify,
            PublicKey key)
            throws Exception
    {
        Signature signature
                = Signature.getInstance(
                SIGNING_ALGORITHM);
        signature.initVerify(key);
        signature.update(input);
        return signature
                .verify(signatureToVerify);
    }

    // Driver Code
    public void use()
    {
        try {

            //Our secret message
            Scanner s = new Scanner(System.in);
            System.out.println("Put message to encrypt: ");
            String input = s.nextLine();

            KeyPair keyPair
                    = Generate_RSA_KeyPair();

            // Function Call
            byte[] signature
                    = Create_Digital_Signature(
                    input.getBytes(),
                    keyPair.getPrivate());

            System.out.println(
                    "Signature Value:\n "
                            + Base64.getEncoder().encodeToString(signature));

            System.out.println(
                    "Verification: "
                            + Verify_Digital_Signature(
                            input.getBytes(),
                            signature, keyPair.getPublic()));
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
