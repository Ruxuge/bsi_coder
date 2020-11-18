package pl.pjatk.bsi_algorytmy;

import pl.pjatk.bsi_algorytmy.expectedBreakdownCost.BreakdownCostCalculator;

public class App {

    private final AlgorithmCaster caster = new AlgorithmCaster();

    private void run() {

        caster.setAlgorithm(new BreakdownCostCalculator());
        caster.cast();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
