package com.pb.petriaievB.hw11;

import java.io.Serializable;
import java.time.*;
import java.util.Arrays;

public class Contact implements Serializable {
    private String name, address;
    private String[] numbers;
    private transient LocalDate born;
    private transient LocalDateTime lastChanges;

    public Contact(String name, String address, String[] numbers,
                   LocalDate born, LocalDateTime lastChanges) {
        this.name = name;
        this.address = address;
        this.numbers = numbers;
        this.born = born;
        this.lastChanges = lastChanges;
    }
    // дефолтный конструктор, без которого сериализация не работала
    public Contact() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }
    public void setBorn(int y, int m, int d) {
        this.born = LocalDate.of(y, m, d);
    }

    public void setLastChanges(LocalDateTime lastChanges) {
        this.lastChanges = lastChanges;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public String getBorn() {
        return born.toString();
    }

    public String getLastChanges() {
        return lastChanges.toString();
    }

    @Override
    public String toString() {
        return "\n{Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Born: " + born + "\n" +
                "Phone number: " + Arrays.toString(numbers) + "\n" +
                "Last changes: " + lastChanges + "}";
    }
}