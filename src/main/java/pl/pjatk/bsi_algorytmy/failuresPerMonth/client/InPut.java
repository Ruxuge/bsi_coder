package pl.pjatk.bsi_algorytmy.failuresPerMonth.client;

import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;
import pl.pjatk.bsi_algorytmy.chipset.validator.ScannerValidateInput;

import java.util.Scanner;
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
public class InPut {
    Scanner scanner = new Scanner(System.in);
    ScannerValidateInput validate = new ScannerValidateInput();

    public void taker(TestingStatistic testingStatistic){
        //taking variables

        System.out.println("Dou you want enter all variables manually? yes/no");
        String check = scanner.nextLine();

        if (check.equals("no") || check.equals("n")) {
            System.out.println("Variables are set automatic.");
            testingStatistic.setTestsNumber(300);
            testingStatistic.setFailures(6);
            testingStatistic.setTestTime(500);

            testingStatistic.setNumberOfChips(300);


        }else {

            System.out.print("Give number of tested Chips: ");
            double doubleValue = validate.validate(scanner.next());
            testingStatistic.setNumberOfChips(doubleValue);

            System.out.print("Give time of tests in hours: ");
            doubleValue = validate.validate(scanner.next());
            testingStatistic.setTestTime(doubleValue);

            System.out.print("Give number of Tests: ");
            doubleValue = validate.validate(scanner.next());
            testingStatistic.setTestsNumber(doubleValue);

            System.out.print("Give number of Failures: ");
            doubleValue = validate.validate(scanner.next());
            testingStatistic.setFailures(doubleValue);
        }
    }



}
