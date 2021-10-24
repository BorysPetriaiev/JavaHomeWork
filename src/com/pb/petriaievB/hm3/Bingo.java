package com.pb.petriaievB.hm3;
import java.util.Scanner;
public class Bingo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = 0;
        int max = 100;
        int bingo = min + (int) (Math.random() * max);
        int tries = 0;
        int num;
        boolean isActive = true;
        int choice;
        while (isActive) {
            do {
                System.out.println("Введите число: ");
                System.out.println("Если хотите закончить игру - введите вне диапазона [0-100]");
                num = scan.nextInt();
                ++tries;
                if (num < 0 || num > 100)
                    break;
                else if (num > bingo) System.out.println("Число слишком высокое!");
                else if (num < bingo) System.out.println("Число слишком низкое!");
                else System.out.printf("Вы победили! Бинго: %s, попыток: %s ", bingo, tries);
            } while (num != bingo);
            System.out.println("Хотите ещё сыграть? 1 - да");
            choice = scan.nextInt();
            isActive = choice != 1 ? false : true;
            if (isActive == false) System.out.println("Игра окончена. До встречи!");
        }
    }
}