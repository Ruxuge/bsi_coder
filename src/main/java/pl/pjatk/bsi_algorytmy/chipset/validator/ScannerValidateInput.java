package pl.pjatk.bsi_algorytmy.chipset.validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerValidateInput {

        public double validate(String number) {
            Scanner scanner = new Scanner(System.in);
            String decimalPattern = ("[\\x00-\\x20]*[+]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                    "([eE][+]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+]?(\\p{Digit}+))?)|" +
                    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
                    "[pP][+]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

            boolean match = Pattern.matches(decimalPattern, number);
            while(!match){
                System.out.println("Enter positive number");
                number = scanner.next();
                match = Pattern.matches(decimalPattern, number);
            }
            return Double.parseDouble(number);

        }
    }
