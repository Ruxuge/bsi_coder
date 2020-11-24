package pl.pjatk.bsi_algorytmy.failuresPerMonth;

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
// @author Filip Werra
import pl.pjatk.bsi_algorytmy.Algorithm;
import pl.pjatk.bsi_algorytmy.failuresPerMonth.client.OutPut;

public class FailuresPerMonth implements Algorithm {

    public static void main(String[] args) {

        OutPut outPut = new OutPut();
        outPut.statisticView();

    }

    @Override
    public void use() {
        OutPut outPut = new OutPut();
        outPut.statisticView();
    }

}