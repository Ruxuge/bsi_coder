package pl.pjatk.bsi_algorytmy;

import pl.pjatk.bsi_algorytmy.chipset.Chipset;
import pl.pjatk.bsi_algorytmy.expectedBreakdownCost.BreakdownCostCalculator;
import pl.pjatk.bsi_algorytmy.failuresPerMonth.FailuresPerMonth;
import pl.pjatk.bsi_algorytmy.highestFailureRate.HighestFailureRateCalculator;

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
                    caster.setAlgorithm(new Chipset());
                    caster.cast();

                    break;
                case 2:
                    caster.setAlgorithm(new FailuresPerMonth());
                    caster.cast();

                    break;
                case 3:
                    caster.setAlgorithm(new HighestFailureRateCalculator());
                    caster.cast();
                    break;
                case 4:

                    break;
                case 5:
                    caster.setAlgorithm(new BreakdownCostCalculator());
                    caster.cast();
                    break;
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
        return Integer.parseInt(scanner.nextLine());
    }

    private void printWelcomeMessage() {
        printer.println("Select option: " +
                "\n\t 1 - Chipset test statistics" +
                "\n\t 2 - Failures per month" +
                "\n\t 3 - Highest failure rate " +
                "\n\t 4 - alg4" +
                "\n\t 5 - Breakdown cost calculator");
    }

    public static void main(String[] args) {
        new App().run();
    }
}
