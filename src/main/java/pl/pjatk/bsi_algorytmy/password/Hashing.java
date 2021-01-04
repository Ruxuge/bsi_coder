package pl.pjatk.bsi_algorytmy.password;

import pl.pjatk.bsi_algorytmy.Algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is hashing text from user.
 * To Hash text program is using salting. All salt is generate in salt().
 * All data is save in saltFile.out
 *
 * @author Filip Werra s19375
 */
public class Hashing implements Algorithm {
    Scanner scanner = new Scanner(System.in);


    /**
     * Use() is main class and it is run from App class.
     * Use is taking string from user and hash it with salting.
     * Every thing is saved in file with BufferWritter.
     */
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

    /**
     * Writer is function to save text, salt and hashed date in file.
     *
     * @param text <- text which will be saved in file. It can be text given by user, salt or hashed text.
     * @throws IOException
     */
    public void Writer(String text)
            throws IOException {
                String str = text;
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/pl/pjatk/bsi_algorytmy/password/saltFile.out", true));
                writer.newLine();
                writer.append(str);

                writer.close();
    }

    /**
     * Salt() is generator of salt. Which is used to make save hashing.
     *
     * @return random salt.
     */
    public byte[] Salt() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        return bytes;
    }
}