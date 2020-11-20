package pl.pjatk.bsi_algorytmy.chipset.client.inOut;

import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;

import java.sql.SQLOutput;
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

public class InPut {
    Scanner scanner = new Scanner(System.in);

    public void taker(TestingStatistic testingStatistic){
        //taking variables

        System.out.printf("Give number of Failures: ");
        testingStatistic.setFailures(scanner.nextDouble());

        failers(testingStatistic);

        testingStatistic.setTestsNumber(scanner.nextDouble());

        testingStatistic.setTestTime(scanner.nextDouble());



    }

    public void failers(TestingStatistic testingStatistic){
        double doubleValue = testingStatistic.getFailures();
        /*int z = (int) doubleValue;

        int p = 2;
        int i = z;

        double[][] tab = new double[i][p];

        i = 0;
        p = 0;

            while(i < z) {
                System.out.println("When was first fail?");
                int number = scanner.nextInt();
                tab[i][p] = number;
                p = 1;
                System.out.println("How much fails?");
                tab[i][p] = scanner.nextInt();
                p = 0;
                i = z - number;
            }*/

            int downtime = 0;

            System.out.println("Num of all fails: ");
            int allFails = scanner.nextInt();

            while (allFails > 0) {

                System.out.println("Time of fail: ");
                int timeOfFail = scanner.nextInt();

                System.out.println("Num of failed Chips: ");
                int numOfChips = scanner.nextInt();

                int testPattern = numOfChips * (500 - timeOfFail);

                downtime += testPattern;
                allFails -= numOfChips;
            }

            System.out.println("Downtime: " + downtime);
        }


        //System.out.println(testingStatistic.getFailures());
    }


}
