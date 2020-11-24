package pl.pjatk.bsi_algorytmy.failuresPerMonth.client;

import pl.pjatk.bsi_algorytmy.chipset.model.TestingStatistic;

import java.util.Scanner;

public class InPut {
    Scanner scanner = new Scanner(System.in);

    public void taker(TestingStatistic testingStatistic){
        //taking variables

        System.out.printf("Give number of tested Chips: ");
        testingStatistic.setNumberOfChips(scanner.nextDouble());

        System.out.println("Dou you want enter all variables manually? (1 = yes/0 = no)");
        Boolean check = scanner.nextBoolean();

        if (!check){
            System.out.println("Veriables are set automatic.");
            Setter setter = new Setter();
            setter.setter();
        }

    }

}
