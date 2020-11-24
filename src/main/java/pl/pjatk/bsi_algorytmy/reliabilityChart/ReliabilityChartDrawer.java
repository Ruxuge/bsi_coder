package pl.pjatk.bsi_algorytmy.reliabilityChart;

import org.jfree.data.xy.XYSeries;
import pl.pjatk.bsi_algorytmy.Algorithm;

import javax.swing.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 * One thousand transistors are placed on life test, and the number of failures in each time
 * Find the reliability and the failure rate at 0, 100, 200, etc hours. (You may find it helpful to set this up on a spreadsheet.)
 * Draw a graph to show the change in the failure rate as the transistors get older.
 * Do you think this component shows the bath tub pattern of failure? Draw a graph to show how the reliability changes over time.
 *
 * @author Aleksander Konieczny
 */
public class ReliabilityChartDrawer implements Algorithm {

    private final Scanner scanner;
    private final PrintStream printer;
    private ChartDrawer chartDrawer;

    public ReliabilityChartDrawer(Scanner scanner, PrintStream printer) {
        this.scanner = scanner;
        this.printer = printer;
    }

    @Override
    public void use() {
        try {
            int initTransistorValue = getInitialTransistorsValue();
            TestUnit.initTransistorsValue = initTransistorValue;
            int numberOfRows = getNumberOfRows();
            List<TestUnit> units = getTestValues(numberOfRows, initTransistorValue);
            chartDrawer = new ChartDrawer(units, scanner, printer);
            chartDrawer.drawFailureRateChart(units);
            chartDrawer.drawReliabilityChart(units);
        } catch (NumberFormatException e) {
            printer.println("Bad input value!");
        }
    }

    private int getInitialTransistorsValue() {
        System.out.println("Enter initial transistors value:");
        return Integer.valueOf(scanner.nextLine());
    }

    private int getNumberOfRows() {
        printer.println("Enter number of rows:");
        return Integer.parseInt(scanner.nextLine());
    }

    private List<TestUnit> getTestValues(int numberOfRows, int initTransistorsNumber) {
        List<TestUnit> list = new ArrayList<>(numberOfRows);
        printer.format("Enter %d rows, each row must contain number of hours, and number of failures separated with space:\n", numberOfRows);

        for (int n = 0; n < numberOfRows; n++) {
            String inputString = scanner.nextLine();
            double[] input = stringToDoubleArray(inputString);
            TestUnit current = new TestUnit(input[0], n == 0 ? (double)initTransistorsNumber : calculateTransistorsValue(list.get(list.size() - 1)), input[1]);
            list.add(current);
        }

        return list;
    }

    private double calculateTransistorsValue(TestUnit unit) {
        return unit.getTransistors() - unit.getFailures();
    }

    private double[] stringToDoubleArray(String in) {
        return Arrays.stream(in.split(" ")).mapToDouble(Double::parseDouble).toArray();
    }
}
