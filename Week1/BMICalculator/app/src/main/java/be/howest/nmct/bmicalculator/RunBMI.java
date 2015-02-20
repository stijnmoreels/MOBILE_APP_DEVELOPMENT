package be.howest.nmct.bmicalculator;

import java.util.Scanner;

import be.howest.nmct.bmicalculator.BMIInfo;

/**
 * Created by Stijn on 12/02/2015.
 */

public class RunBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BMIInfo bmi = new BMIInfo();

        System.out.println("Enter your height(in m, eg: 1.72)");
        bmi.setHeight(scanner.nextFloat());
        System.out.println("Enter your mass(in kg, eg: 70)");
        bmi.setMass(scanner.nextInt());
        bmi.recalculate();
        System.out.println("Your body mass index is: " + bmi.getBmiIndex() + ", you are in the category: " + bmi.GetCategory());
    }
}
