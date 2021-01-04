package pl.pjatk.bsi_algorytmy.password;

import pl.pjatk.bsi_algorytmy.Algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;


public class Hashing implements Algorithm {
    Scanner scanner = new Scanner(System.in);

    public void use() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            System.out.println("Input your text to hash");
            String text = scanner.nextLine();

            String salt = Arrays.toString(Salt());

            Writer("Text: " + text);
            Writer("Salt: " + salt);

            String saltAndText;
            saltAndText = text + salt;

            Writer("To jest text i salt " + saltAndText);

            byte[] hash = digest.digest(saltAndText.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            String SaltedText = hexString.toString();

            System.out.println(SaltedText);
            Writer("Posolony text: " + SaltedText);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void Writer(String text)
            throws IOException {
                String str = text;
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/pl/pjatk/bsi_algorytmy/password/saltFile.out", true));
                writer.newLine();
                writer.append(str);

                writer.close();
    }

    public byte[] Salt() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        return bytes;
    }
}