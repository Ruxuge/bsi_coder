package pl.pjatk.bsi_algorytmy.expectedBreakdownCost;

public class Row {

    private double numberOfBreakdowns;
    private double dailyFrequency;
    private double probability;

    public Row(double numberOfBreakdowns, double dailyFrequency) {
        this.numberOfBreakdowns = numberOfBreakdowns;
        this.dailyFrequency = dailyFrequency;
        this.probability = dailyFrequency / 10;
    }

    public double getNumberOfBreakdowns() {
        return numberOfBreakdowns;
    }

    public double getProbability() {
        return probability;
    }

}
