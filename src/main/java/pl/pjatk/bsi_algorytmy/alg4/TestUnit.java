package pl.pjatk.bsi_algorytmy.alg4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestUnit {

    private int time;
    private int transistors;
    private int failures;
    private double reliability;
    private double failureRate;

    public TestUnit(int time, int transistors, int failures) {
        this.time = time;
        this.transistors = transistors;
        this.failures = failures;
        this.reliability =  getDouble((double)transistors / (double)Main.initTransistors);
        this.failureRate = failures == 0 ? 0 : getDouble((double)failures / (double)transistors);
    }

    private double getDouble(double value) {
        BigDecimal bd = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTransistors() {
        return transistors;
    }

    public void setTransistors(int transistors) {
        this.transistors = transistors;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public double getReliability() {
        return reliability;
    }

    public void setReliability(double reliability) {
        this.reliability = reliability;
    }

    public double getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(double failureRate) {
        this.failureRate = failureRate;
    }
}
