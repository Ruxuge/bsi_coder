package pl.pjatk.bsi_algorytmy.highestFailureRate;

import pl.pjatk.bsi_algorytmy.Algorithm;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * What is the highest failure rate for a product if it is to have a reliability (or probability of survival) of 98 percent at 5000 hours?
 * Assume that the time to failure follows an exponential distribution.
 * @author Aleksander Konieczny
 */
public class HighestFailureRateCalculator implements Algorithm {

    private final Scanner scanner = new Scanner(System.in);
    private final PrintStream printer = System.out;

    @Override
    public void use() {
        int hours = getHours();
        double percentage = getReliability();
        double result = calculateResult(hours, percentage);
        printer.format("Highest failure rate is %.8f\n", result);
    }

    private double calculateResult(int hours, double percentage) {
        return Math.log(percentage)/hours * -1;
    }

    private int getHours() {
        printer.println("Enter number of hours:");
        return Integer.parseInt(scanner.nextLine());
    }

    private double getReliability() {
        printer.println("Enter percentage of reliability (0.xx format):");
        return Double.parseDouble(scanner.nextLine());
    }

}
