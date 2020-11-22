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

        public void calculate(TestingStatistic testingStatistic) {


            testingStatistic.setTotalTime(testingStatistic.getTestsNumber() * testingStatistic.getTestTime());

            testingStatistic.setOperatingTime(testingStatistic.getTotalTime() - testingStatistic.getDownTime());

            testingStatistic.setFrPerTest(testingStatistic.getFailures() / testingStatistic.getTestsNumber());

            testingStatistic.setFrPerTime(testingStatistic.getFailures() / testingStatistic.getOperatingTime());

            testingStatistic.setMTBF( 1 / testingStatistic.getFrPerTime());


            //failuresPerMonth
            testingStatistic.setFailuresPerMonth(testingStatistic.getFrPerTest() * (24 * 30));

            testingStatistic.setMTBFinDays(testingStatistic.getMTBF() / 30);
    }
}
