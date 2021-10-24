package com.pb.petriaievB.hm3;
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[10];
        System.out.println("Введите 10 цельночисленных значений: ");
        for (int a = 0; a < nums.length; a++) {
            nums[a] = scan.nextInt();
        }
        System.out.printf("Ваш массив: %s", Arrays.toString(nums));
        // сумма массива
        int sum = 0;
        for (int l = 0; l < nums.length; l++) {
            sum += nums[l];
        }
        System.out.printf("\nСумма всех элементов массива: %s", sum);
        // кол-во положительных элементов
        int positive_int = 0;
        for (int b = 0; b < nums.length; b++) {
            if (nums[b] > 0)
                positive_int++;
        }
        System.out.printf("\nКоличество положительных элементов массива: %s", positive_int);
        // сортировка пузырьком
        boolean sorted = false;
        int x;
        while (!sorted) {
            sorted = true;
            for (int n = 0; n < nums.length - 1; n++) {
                if (nums[n] > nums[n + 1]) {
                    x = nums[n];
                    nums[n] = nums[n+1];
                    nums[n+1] = x;
                    sorted = false;
                }
            }
        }
        System.out.printf("\nОтсортированный массив: %s", Arrays.toString(nums));
    }
}
