package com.pb.petriaievB.hw9;

import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileNumbers {
    public static void createNumbersFile() throws IOException {
        // создание файла
        Path path = Files.createFile(Paths.get(
                "/Users/boryspetriaiev/Desktop/JavaHomeWork/src/com/pb/petriaievB/hw9/numbers.txt"));
        // заполнение файла
        Random r = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(100);
        try (BufferedWriter w = Files.newBufferedWriter(path)) {
            for (int i = 0; i <= arr.length - 1; i++) {
                if (i % 10 == 0 && i != 100)
                    w.write("\n" + arr[i] + " ");
                else
                    w.write(arr[i] + " ");
            }
        }
    }

    public static void createOddNumbersFile() throws IOException {
        // чтение файла
        Path path = Paths.get(
                "/Users/boryspetriaiev/Desktop/JavaHomeWork/src/com/pb/petriaievB/hw9/numbers.txt");
        try {
            Scanner s = new Scanner(path);
            int i = 0;
            while (s.hasNextInt()) {
                i++;
                s.nextInt();
            }
            int[] array = new int[i];
            Scanner s1 = new Scanner(path);
            for (int n = 0; n < array.length; n++) {
                array[n] = s1.nextInt();
            }
            for (int n = 0; n < array.length; n++) {
                if (array[n] % 2 == 0)
                    array[n] = 0;
            }
            // запись файла
            Path anotherPath = Files.createFile(Paths.get(
                    "/Users/boryspetriaiev/Desktop/JavaHomeWork/src/com/pb/petriaievB/hw9/odd-numbers.txt"));
            try (BufferedWriter w = Files.newBufferedWriter(anotherPath)) {
                for (int n = 0; n <= array.length - 1; n++) {
                    if (n % 10 == 0) {
                        w.write("\n" + array[n] + " ");
                    }
                    else
                        w.write(array[n] + " ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            createNumbersFile();
            createOddNumbersFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}