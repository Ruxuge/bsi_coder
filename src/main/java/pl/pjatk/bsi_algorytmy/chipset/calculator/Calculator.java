package pl.pjatk.bsi_algorytmy.chipset.calculator;

import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;

public class Calculator {
    //public void calculate(
     //       double frPerTest, double frPerTime, double totalTime, double downTime, double operatingTime, double MTBF, double failures, double nTests) {
        public void calculate(TestingStatistic testingStatistic) {

            testingStatistic.setTotalTime(300*500);

            /*totalTime = 300 * 500;

            downTime = (2 * 450) + (2 * 400) + 200 + 100;

            operatingTime = totalTime - downTime;

            frPerTest = (failures * 100) / nTests;

            frPerTime = failures / operatingTime;

            MTBF = 1 / frPerTime;*/
    }
}
