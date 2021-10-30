package com.pb.petriaievB.hm4;

import java.util.Scanner;
public class CapitalLetter {
    static void Capitalize(String x) {
        System.out.printf("\nИзначальный текст: %s", x);
        char[] Array = x.toCharArray();
        boolean Space = true;

        for (int i=0; i<Array.length; i++) {
            if(Character.isLetter(Array[i])) {
                if(Space) {
                    Array[i] = Character.toUpperCase(Array[i]);
                    Space = false;
                }
            }  else Space = true;
        }
        x = String.valueOf(Array);
        System.out.printf("\nИзмененный текст: %s", x);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scan.nextLine();
        Capitalize(text);
    }
}
