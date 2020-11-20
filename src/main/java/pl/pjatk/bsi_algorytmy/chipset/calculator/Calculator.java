package pl.pjatk.bsi_algorytmy.chipset.calculator;

import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;

/**
 FR(%) = failures per number tested = 6/300 = 0.02 = 2%
 FR(N) = failures per operating time:
 Total time = 300 * 500 = 150,000 hours
 Downtime = 2(450) + 2(400) + 1(200) + 1(100) = 2,000 hours
 Operating time = Total time – Downtime = 150,000 – 2,000 = 148,000
 Therefore: FR(N) = 6/148,000 = 0.0000405 failures/hour
 MTBF = 1/FR(N) = 24,691 hours
 */

public class Calculator {
    //public void calculate(
     //       double frPerTest, double frPerTime, double totalTime, double downTime, double operatingTime, double MTBF, double failures, double nTests) {
        public void calculate(TestingStatistic testingStatistic) {

            testingStatistic.setTotalTime(300*500);

            testingStatistic.setDownTime((2 * 450) + (2 * 400) + 200 + 100);

            testingStatistic.setOperatingTime(150000 - 2000);

            testingStatistic.setFailures(6);

            testingStatistic.setnTests(300);

            testingStatistic.getFrPerTest((6 * 100) / 300);

            testingStatistic.getFrPerTime(6 / 148000);

            testingStatistic.setMTBF(1/ 0.0000405);
            /*

            operatingTime = totalTime - downTime;

            frPerTest = (failures * 100) / nTests;

            frPerTime = failures / operatingTime;

            MTBF = 1 / frPerTime;*/
    }
}
