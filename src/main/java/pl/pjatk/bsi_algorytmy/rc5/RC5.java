package pl.pjatk.bsi_algorytmy.rc5;
import java.io.*;
import java.util.Arrays;

import pl.pjatk.bsi_algorytmy.Algorithm;
/**
 * This class is hashing text from user.
 * To Hash text program is using salting. All salt is generate in salt().
 * All data is save in saltFile.out
 *
 * @author Filip Magdziak s19616
 */
public class RC5 implements Algorithm {
    String[] avs = {"1"};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Encryption");
        RC5Enc enc = new RC5Enc();
        enc.encrypt();
        System.out.println("Encryption");
        RC5Dec dec = new RC5Dec();
        dec.decrypt();
    }
    public void use(){
        try{
            main(avs);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
