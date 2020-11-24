package pl.pjatk.bsi_algorytmy.chipset.client;

import pl.pjatk.bsi_algorytmy.chipset.calculator.Calculator;
import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;
// @author Filip Werra
public class OutPut {
    public void statisticView(){
        Calculator calculator = new Calculator();
        TestingStatistic testingStatistic = new TestingStatistic();
        InPut inPut = new InPut();
        inPut.taker(testingStatistic);
        calculator.calculate(testingStatistic);

        //text formating
        String frPerTime = String.format("%.7f", testingStatistic.getFrPerTime());
        String mtbf = String.format("%.2f", testingStatistic.getMTBF());
        String frPerTest = String.format("%.2f", testingStatistic.getFrPerTest());
        String totalTime = String.format("%.2f", testingStatistic.getTotalTime());
        String failures = String.format("%.2f", testingStatistic.getFailures());
        String downTime = String.format("%.2f", testingStatistic.getDownTime());
        String tetsNumber = String.format("%.2f", testingStatistic.getTestsNumber());
        String operatingTime = String.format("%.2f", testingStatistic.getOperatingTime());

        System.out.println("Total Time: "+totalTime);

        System.out.println("Down Time: "+downTime);

        System.out.println("Failures: "+failures);

        System.out.println("FrPerTest: "+frPerTest);

        System.out.println("FrPerTime: "+frPerTime);

        System.out.println("MTBF: "+mtbf);

        System.out.println("Tets Number: "+tetsNumber);

        System.out.println("Operating Time: "+operatingTime);

    }
}
