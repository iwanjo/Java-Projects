package com.company;
//Done by Ian Wanjohi --> This is a program that is designd to calculate the mortgage payments on a house.
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Here we are declaring byte variables and storing the months in the year and percent. I have stored them as
        //final so that the computer understands that it is a constant value.
        final byte monthsInYear = 12;
        final byte percent = 100;

        //And here we are declaring a Scanner object
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the principal amount: ");
        int principal = scanner.nextInt();

        System.out.println("What is the annual interest rate?: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / percent / monthsInYear;

        System.out.println("What is the period in years?: ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * monthsInYear;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage: " + mortgage);
    }
}
