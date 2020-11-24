package pl.pjatk.bsi_algorytmy;

import pl.pjatk.bsi_algorytmy.expectedBreakdownCost.BreakdownCostCalculator;
import pl.pjatk.bsi_algorytmy.highestFailureRate.HighestFailureRateCalculator;
import pl.pjatk.bsi_algorytmy.reliabilityChart.ReliabilityChartDrawer;

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

                    break;
                case 2:

                    break;
                case 3:
                    caster.setAlgorithm(new HighestFailureRateCalculator());
                    caster.cast();
                    break;
                case 4:
                    caster.setAlgorithm(new ReliabilityChartDrawer());
                    caster.cast();
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
                "\n\t 1 - alg1" +
                "\n\t 2 - alg2" +
                "\n\t 3 - Highest failure rate " +
                "\n\t 4 - Reliability chart drawer" +
                "\n\t 5 - Breakdown cost calculator");
    }

    public static void main(String[] args) {
        new App().run();
    }
}
