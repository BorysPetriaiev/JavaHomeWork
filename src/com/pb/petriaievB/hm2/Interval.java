package com.pb.petriaievB.hm2;
import java.util.Scanner;
public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("print any integer (whole number):");
        int wholeNumber = scan.nextInt();
        if (wholeNumber == 0) {
            System.out.println("Is a number = 0");
        }
        else if (wholeNumber <0) {
            System.out.println("Is a number lower than 0");
        }
        else if (wholeNumber <= 14) {
            System.out.println("is a number in the range 1-14");
        }
        else if (wholeNumber <= 35) {
            System.out.println("is a number in the range 15-35");
        }
        else if (wholeNumber <= 50) {
            System.out.println("is a number in the range 36-50");
        }
        else if (wholeNumber <=100) {
            System.out.println("is a number in the range 51-100");
        }
        else {
            System.out.println("is a number in the range 101-***");
        }

    }
}
