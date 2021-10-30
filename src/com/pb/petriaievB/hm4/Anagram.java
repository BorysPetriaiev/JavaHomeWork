package com.pb.petriaievB.hm4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    static void isAnagram(String x, String y) {
        String s1 = x.replaceAll("\\s", "");
        String s2 = y.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] Array1 = s1.toUpperCase().toCharArray();
            char[] Array2 = s2.toUpperCase().toCharArray();
            Arrays.sort(Array1);
            Arrays.sort(Array2);
            status = Arrays.equals(Array1, Array2);
        }
        if (status)
            System.out.println("Это анаграммы.");
        else System.out.println("Это не анаграммы.");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое предложение: ");
        String first = scan.nextLine();
        System.out.println("Введите второе предложение: ");
        String second = scan.nextLine();
        isAnagram(first, second);
    }
}