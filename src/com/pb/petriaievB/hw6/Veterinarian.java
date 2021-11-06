package com.pb.petriaievB.hw6;

public class Veterinarian {
    private String name;
    public Veterinarian(String name) {
        this.name = name;
    }
    public static String treatAnimal(Animal animal) {
        return "\n[Имя животного: " + animal.getName() +
                "\nЕда животного: " + animal.getFood() +
                "\nСреда обитания: " + animal.getLocation() + "]";
    }
}
