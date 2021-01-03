package pl.pjatk.bsi_algorytmy;

import pl.pjatk.bsi_algorytmy.aes.Aes;
import pl.pjatk.bsi_algorytmy.rc5.Rc5;
import pl.pjatk.bsi_algorytmy.salting.Salt;
import pl.pjatk.bsi_algorytmy.tDes.TripleDes;

import java.io.PrintStream;
import java.util.Scanner;

public class App {

    private final AlgorithmCaster caster = new AlgorithmCaster();
    private final Scanner scanner = new Scanner(System.in);
    private final PrintStream printer = System.out;

    private boolean keepRunning = true;

    public void run() {
        printWelcomeMessage();

        while (keepRunning) {

            int option = getMenuOption();

            switch (option) {
                case 1:
                    caster.setAlgorithm(new Rc5());
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
                    caster.setAlgorithm((new Salt()));
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

    private int getMenuOption() {
        printer.println("\nEnter your option:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void printWelcomeMessage() {
        printer.println("Select option: " +
                "\n\t 1 - RC5"+
                "\n\t 2 - AES"+
                "\n\t 3 - 3DES"+
                "\n\t 4 - Salting"
        );
    }

    public static void main(String[] args) {
        new App().run();
    }
}
