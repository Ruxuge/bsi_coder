package pl.pjatk.bsi_algorytmy.alg5;

import java.util.*;

/**
 * @author Aleksander Konieczny
 */
class Main {
    public static void main(String[] args) {
        List<Row> rows = new ArrayList<>();
        int costPerBreakdown = 10;
        rows.add(new Row(0, 3));
        rows.add(new Row(1, 2));
        rows.add(new Row(2, 2));
        rows.add(new Row(3, 3));

        double result = rows.stream().map(e -> e.getNumberOfBreakdowns() * e.getDailyFrequency()).reduce(0.0, (a, b) -> a+b);
        System.out.println("$"+result);
    }
}