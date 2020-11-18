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

    public void setNumberOfBreakdowns(double numberOfBreakdowns) {
        this.numberOfBreakdowns = numberOfBreakdowns;
    }

    public double getDailyFrequency() {
        return dailyFrequency;
    }

    public void setDailyFrequency(double dailyFrequency) {
        this.dailyFrequency = dailyFrequency;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
