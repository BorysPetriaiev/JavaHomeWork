package com.pb.petriaievB.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants() {
        super("Штаны", Size.M, "Черный", 40.00);
    }
    @Override
    public void dressMan() {
        //   System.out.println("Мужчина надевает штаны.");
    }
    @Override
    public void dressWomen() {
        //     System.out.println("Женщина надевает штаны.");
        System.out.printf("\nТип одежды: %s",
                "\nЦена: %s USD" +
                        "\nРазмер: %s." +
                        "\nЦвет: %s. ",
                name, price,
                size, color);
    }
}