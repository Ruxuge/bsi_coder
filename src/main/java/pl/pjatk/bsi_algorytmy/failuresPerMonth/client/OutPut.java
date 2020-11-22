package pl.pjatk.bsi_algorytmy.failuresPerMonth.client;

import pl.pjatk.bsi_algorytmy.chipset.calculator.Calculator;
import pl.pjatk.bsi_algorytmy.failuresPerMonth.client.InPut;
import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;

/*
If 300 of these chips are used in building a mainframe computer, how many failures of the computer can be expected per month?

*/

/*
Converting the units of FR(N) to months:
FR(N) = 0.0000405 * 24 hours/day * 30 days/month = 0.029 failures/month

FR(N) for the 300 units:
FR(N) = 0.029 failures/month * 300 units = 8.75 failures/month

MTBF for the mainframe:
MTBF = 1/FR(N) = 1/8.75 = 0.11 month = 0.11 * 30 = 3.4 days

Calculation for MTBF assumes that failure of any one chip brings down entire system.

*/

public class OutPut {
    public void statisticView() {
        Calculator calculator = new Calculator();
        TestingStatistic testingStatistic = new TestingStatistic();
        pl.pjatk.bsi_algorytmy.failuresPerMonth.client.InPut inPut = new InPut();
        inPut.taker(testingStatistic);
        calculator.calculate(testingStatistic);

        //text formating
        String frPerTime = String.format("%.2f", testingStatistic.getFrPerTime());
        String MTBF = String.format("%.2f", testingStatistic.getMTBF());
        String numberOfChips = String.format("%.0f", testingStatistic.getNumberOfChips());
        String failuresPerMonth = String.format("%.2f", testingStatistic.getFailuresPerMonth());

        System.out.println("Total time: " + frPerTime);
        System.out.println("MTBF: " + MTBF);
        System.out.println("Number of tested chips : " + numberOfChips);
        System.out.println("Failures per month: " + failuresPerMonth);
    }

}
