package pl.pjatk.bsi_algorytmy.chipset.client;

import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;
import pl.pjatk.bsi_algorytmy.chipset.validator.ScannerValidateInput;

import java.util.Scanner;

/**
 California Instruments, Inc., produces 3,000 computer chips per day. Three hundred are tested for a period of 500 operating hours each.
 During the test, six failed: two after 50 hours, two at 100 hours, one at 300 hours, and one at 400 hours.
 Find FR(%) and FR(N).
 */

/**
 FR(%) = failures per number tested = 6/300 = 0.02 = 2%
 FR(N) = failures per operating time:
 Total time = 300 * 500 = 150,000 hours
 Downtime = 2(450) + 2(400) + 1(200) + 1(100) = 2,000 hours
 Operating time = Total time – Downtime = 150,000 – 2,000 = 148,000
 Therefore: FR(N) = 6/148,000 = 0.0000405 failures/hour
 MTBF = 1/FR(N) = 24,691 hours
 */
// @author Filip Werra
public class InPut {
    Scanner scanner = new Scanner(System.in);
    ScannerValidateInput validate = new ScannerValidateInput();

    public void taker(TestingStatistic testingStatistic){
        //taking variables

        System.out.println("Dou you want enter all variables manually? yes/no");
        String check = scanner.nextLine();

        if (check.equals("no") || check.equals("n")){
            System.out.println("Variables are set automatic.");
            testingStatistic.setTestsNumber(300);
            testingStatistic.setFailures(6);
            testingStatistic.setTestTime(500);
            testingStatistic.setDownTime(2000);


            /*testingStatistic.setFrPerTime(0.0000405);
            testingStatistic.setFrPerTest(0.02);
            testingStatistic.setOperatingTime(148000);
            testingStatistic.setMTBF(24691);
            testingStatistic.setTotalTime(150000);*/
        }else {

            System.out.print("Give time of tests in hours: ");
            double doubleValue = validate.validate(scanner.next());
            testingStatistic.setTestTime(doubleValue);

            System.out.print("Give number of Failures: ");
            doubleValue = validate.validate(scanner.next());
            testingStatistic.setFailures(doubleValue);

            failers(testingStatistic);

            System.out.print("Give number of Tests: ");
            doubleValue = validate.validate(scanner.next());
            testingStatistic.setTestsNumber(doubleValue);
        }

    }

    public void failers(TestingStatistic testingStatistic) {

        Scanner scanner = new Scanner(System.in);

        int downtime = 0;

        double doubleValue = testingStatistic.getFailures();
        int allFails = (int) doubleValue;

        double doubleValue2 = testingStatistic.getTestTime();
        int testTime = (int) doubleValue2;

        while (allFails > 0) {

            System.out.println("Time of fail: ");
            doubleValue = validate.validate(scanner.next());
            int timeOfFail = (int) doubleValue;

            System.out.println("Num of failed Chips: ");
            doubleValue = validate.validate(scanner.next());
            int numOfChips = (int) doubleValue;

            int testPattern = numOfChips * (testTime - timeOfFail);

            downtime += testPattern;
            allFails -= numOfChips;
        }

        testingStatistic.setDownTime(downtime);
    }


}