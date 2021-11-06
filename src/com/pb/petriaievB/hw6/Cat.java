package com.pb.petriaievB.hw6;
import java.util.Objects;

public class Cat extends Animal {
    public Cat() {
        super(" Марго", "Корм кошачий", "Дом");
    }

    @Override
    public void eat() {
        System.out.printf("\n%s Кошка ест %s", getFood());
    }

    @Override
    public void makeNoise() {
        System.out.printf("\n%s говорит мяу-мяу", getName());
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + getName() + '\'' +
                ", food=" + getFood() + '\'' +
                ", location=" + getLocation() + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return
                Objects.equals(getName(), cat.getName()) &&
                        Objects.equals(getFood(), cat.getFood())
                        && Objects.equals(getLocation(), cat.getLocation());
    }
}