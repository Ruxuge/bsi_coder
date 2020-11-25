package pl.pjatk.bsi_algorytmy.reliabilityChart;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestUnit {

    public static int initTransistorsValue;

    private double time;
    private double transistors;
    private double failures;
    private double reliability;
    private double failureRate;

    public TestUnit(double time, double transistors, double failures) {
        this.time = time;
        this.transistors = transistors;
        this.failures = failures;
        this.reliability =  getDouble(transistors / (double) initTransistorsValue);
        this.failureRate = failures == 0 ? 0 : getDouble(failures / transistors);
    }

    private double getDouble(double value) {
        BigDecimal bd = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTransistors() {
        return transistors;
    }

    public void setTransistors(double transistors) {
        this.transistors = transistors;
    }

    public double getFailures() {
        return failures;
    }

    public void setFailures(double failures) {
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
