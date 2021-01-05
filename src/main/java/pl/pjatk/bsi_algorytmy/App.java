package pl.pjatk.bsi_algorytmy;

import pl.pjatk.bsi_algorytmy.aes.Aes;
import pl.pjatk.bsi_algorytmy.dsa.Dsa;
import pl.pjatk.bsi_algorytmy.password.Hashing;
import pl.pjatk.bsi_algorytmy.rc5.RC5;
import pl.pjatk.bsi_algorytmy.rsa.Rsa;
import pl.pjatk.bsi_algorytmy.tDes.TripleDes;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * App is class with menu based on case and welcome message.
 *
 * @author Filip Werra s19375
 */

public class App {

    private final AlgorithmCaster caster = new AlgorithmCaster();
    private final Scanner scanner = new Scanner(System.in);
    private final PrintStream printer = System.out;

    private boolean keepRunning = true;

    /**
     * Run() is menu with cases.
     */
    public void run() {
        printWelcomeMessage();

        while (keepRunning) {

            int option = getMenuOption();

            switch (option) {
                case 1:
                    caster.setAlgorithm(new RC5());
                    caster.cast();
                    break;
                case 2:
                    caster.setAlgorithm(new Aes());
                    caster.cast();
                    break;
                case 3:
                    caster.setAlgorithm((new TripleDes()));
                    caster.cast();
                case 4:
                    caster.setAlgorithm((new Hashing()));
                    caster.cast();
                case 5:
                    caster.setAlgorithm(new Rsa());
                    caster.cast();
                case 6:
                    caster.setAlgorithm(new Dsa());
                    caster.cast();
                case 0:
                    keepRunning = false;
                    printer.println("Goodbye!");
                    break;
                default:
                    printer.println("Invalid option");
                    break;
            }
        }
    }

    /**
     * This class is taking number from user and it used in run to choose option.
     *
     *
     * @return number of option in menu.
     */
    private int getMenuOption() {
        printer.println("\nEnter your option:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Function to print Welcome message with menu.
     */
    private void printWelcomeMessage() {
        printer.println("Select option: " +
                "\n\t 1 - RC5"+
                "\n\t 2 - AES"+
                "\n\t 3 - 3DES"+
                "\n\t 4 - Hashing"+
                "\n\t 5 - Rsa"+
                "\n\t 6 - Des"

        );
    }

    /**
     * Min class is starting program.
     *
     * @param args
     */
    public static void main(String[] args) {
        new App().run();
    }
}
