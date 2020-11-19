package pl.pjatk.bsi_algorytmy.chipset.client;

import pl.pjatk.bsi_algorytmy.chipset.calculator.Calculator;
import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;


public class Client {
    public void statisticView(){
        Calculator calculator = new Calculator();
        TestingStatistic testingStatistic = new TestingStatistic();
        calculator.calculate(testingStatistic);

        System.out.println(testingStatistic.getTotalTime());
    }
}
