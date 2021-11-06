package com.pb.petriaievB.hw6;
import java.util.Objects;

public class Horse extends Animal {
    public Horse() {
        super("Торнадо", "Сено", "Конюшня");
    }
    @Override
    public void eat() {
        System.out.printf("\nЛошадь ест %s.", getFood());
    }
    @Override
    public void makeNoise() {
        System.out.printf("\n%s говорит и-го-го", getName());
    }
    @Override
    public String toString() {
        return "Horse{" + "name=" + getName() + '\'' +
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
        Horse horse = (Horse) o;
        return
                Objects.equals(getName(), horse.getName()) &&
                        Objects.equals(getFood(), horse.getFood())
                        && Objects.equals(getLocation(), horse.getLocation());
    }
}
