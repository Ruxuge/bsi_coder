package pl.pjatk.bsi_algorytmy.alg4;

import javax.swing.*;
import java.util.*;

/**
 * One thousand transistors are placed on life test, and the number of failures in each time
 * Find the reliability and the failure rate at 0, 100, 200, etc hours. (You may find it helpful to set this up on a spreadsheet.)
 * Draw a graph to show the change in the failure rate as the transistors get older.
 * Do you think this component shows the bath tub pattern of failure? Draw a graph to show how the reliability changes over time.
 *
 * @author Aleksander Konieczny
 */
class Main {

    public static int initTransistors = 1000;

    private static List<TestUnit> getTestValues() {
        ArrayList<TestUnit> unitList = new ArrayList<>();
        unitList.add(new TestUnit(0, initTransistors, 160));
        unitList.add(new TestUnit(100, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 86));
        unitList.add(new TestUnit(200, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 78));
        unitList.add(new TestUnit(300, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 70));
        unitList.add(new TestUnit(400, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 64));
        unitList.add(new TestUnit(500, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 58));
        unitList.add(new TestUnit(600, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 52));
        unitList.add(new TestUnit(700, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 43));
        unitList.add(new TestUnit(800, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 42));
        unitList.add(new TestUnit(900, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 36));
        //unitList.add(new TestUnit(1000, calculateTransistorsValue(unitList.get(unitList.size() - 1)), 0));
        return unitList;
    }

    private static int calculateTransistorsValue(TestUnit unit) {
        return unit.getTransistors() - unit.getFailures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Chart("Failure Rate", getTestValues(), true);
            new Chart("Reliability", getTestValues(), false);
        });
    }
}