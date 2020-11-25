package pl.pjatk.bsi_algorytmy.reliabilityChart;

import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * @author Aleksander Konieczny
 */
public class ChartDrawer {

    private final List<TestUnit> data;
    private final Scanner scanner;
    private final PrintStream printer;

    public ChartDrawer(List<TestUnit> data, Scanner scanner, PrintStream printer) {
        this.scanner = scanner;
        this.printer = printer;
        this.data = data;
    }

    void drawReliabilityChart(List<TestUnit> units) {
        final String name = "Reliability";
        if(chartDrawAgreement(name)) {
            XYSeries series = new XYSeries(name);
            units.stream().forEach(e -> series.add(e.getTime(), e.getReliability()));
            showChart(name, series);
        }
    }

    void drawFailureRateChart(List<TestUnit> units) {
        final String name = "Failure Rate";
        if(chartDrawAgreement(name)) {
            XYSeries series = new XYSeries(name);
            units.stream().forEach(e -> series.add(e.getTime(), e.getFailureRate()));
            showChart(name, series);
        }
    }

    private void showChart(String name, XYSeries series) {
        SwingUtilities.invokeLater(() -> new Chart(name, series));
    }

    private boolean chartDrawAgreement(String name) {
        printer.format("Do you want to display %s char (Y/N)", name);
        String in = scanner.nextLine();
        if(in.toLowerCase().equals("y")) return true;
        return false;
    }
}
