package pl.pjatk.bsi_algorytmy.chipset.model;
// @author Filip Werra
public class TestingStatistic {

    private double frPerTest;
    private double frPerTime;
    private double totalTime;
    private double downTime;
    private double operatingTime;
    private double MTBF;
    private double failures;
    private double testsNumber;

    //failuresPerMonth Start
    private double failuresPerMonth;
    private double numberOfChips;
    private double MTBFinDays;

    public double getNumberOfChips() {
        return numberOfChips;
    }

    public void setNumberOfChips(double numberOfChips) {
        this.numberOfChips = numberOfChips;
    }

    public double getFailuresPerMonth() {
        return failuresPerMonth;
    }

    public void setFailuresPerMonth(double failuresPerMonth) {
        this.failuresPerMonth = failuresPerMonth;
    }

    public double getMTBFinDays() {
        return MTBFinDays;
    }

    public void setMTBFinDays(double MTBFinDays) {
        this.MTBFinDays = MTBFinDays;
    }
    //failuresPerMonth End

    public double getTestTime() {
        return testTime;
    }

    public void setTestTime(double testTime) {
        this.testTime = testTime;
    }

    private double testTime;

    public double getFrPerTest() {
        return frPerTest;
    }

    public void setFrPerTest(double frPerTest) {
        this.frPerTest = frPerTest;
    }

    public double getFrPerTime() {
        return frPerTime;
    }

    public void setFrPerTime(double frPerTime) {
        this.frPerTime = frPerTime;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getDownTime() {
        return downTime;
    }

    public void setDownTime(double downTime) {
        this.downTime = downTime;
    }

    public double getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(double operatingTime) {
        this.operatingTime = operatingTime;
    }

    public double getMTBF() {
        return MTBF;
    }

    public void setMTBF(double MTBF) {
        this.MTBF = MTBF;
    }

    public double getFailures() {
        return failures;
    }

    public void setFailures(double failures) {
        this.failures = failures;
    }

    public double getTestsNumber() {
        return testsNumber;
    }

    public void setTestsNumber(double testsNumber) {
        this.testsNumber = testsNumber;
    }

}
