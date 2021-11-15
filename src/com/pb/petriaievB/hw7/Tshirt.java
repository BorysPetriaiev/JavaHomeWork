package com.pb.petriaievB.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
    public Tshirt() {
        super("Футболка", Size.XS, "Черный", 35.55);
    }
    @Override
    public void dressMan() {
        // System.out.println("Мужчина надевает футболку.");
    }
    @Override
    public void dressWomen() {
        //  System.out.println("Женщина надевает футболку.");
        System.out.printf("\nТип одежды: %s",
                "\nЦена: %s USD" +
                        "\nРазмер: %s." +
                        "\nЦвет: %s. ",
                name, price,
                size, color);
    }
}