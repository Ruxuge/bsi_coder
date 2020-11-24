package pl.pjatk.bsi_algorytmy.expectedBreakdownCost;

import pl.pjatk.bsi_algorytmy.Algorithm;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 * Given the probabilities below, calculate the expected breakdown cost.
 *
 * @author Aleksander Konieczny
 */
public class BreakdownCostCalculator implements Algorithm {

    private final Scanner scanner;
    private final PrintStream printer;

    public BreakdownCostCalculator(Scanner scanner, PrintStream printer) {
        this.scanner = scanner;
        this.printer = printer;
    }

    @Override
    public void use() {
        double breakdownCost = getBreakdownCost();
        List<Row> rows = getRows(getNumberOfRows());
        double result = calculateResult(rows, breakdownCost);
        printer.println("Result is: $" + result);
    }

    private double calculateResult(List<Row> rows, double cost) {
        return rows.stream().map(e -> e.getNumberOfBreakdowns() * e.getProbability()).reduce(0.0, (a, b) -> a+b) * cost;
    }

    private double getBreakdownCost() {
        printer.println("Enter breakdown cost:");
        return Double.parseDouble(scanner.nextLine());
    }

    private int getNumberOfRows() {
        printer.println("Enter number of rows:");
        return Integer.parseInt(scanner.nextLine());
    }

    private List<Row> getRows(int numberOfRows) {
        List<Row> rows = new ArrayList<>();
        printer.format("Enter %d rows, each row must contain number of breakdowns and daily frequency separated with space:\n", numberOfRows);

        for (int n = 0; n < numberOfRows; n++) {
            String inputString = scanner.nextLine();
            double[] input = stringToDoubleArray(inputString);
            rows.add(new Row(input[0], input[1]));
        }

        return rows;
    }

    private double[] stringToDoubleArray(String in) {
        return Arrays.stream(in.split(" ")).mapToDouble(Double::parseDouble).toArray();
    }
}
