package com.pb.petriaievB.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt() {
        super("Юбка", Size.L, "красный", 25.00);
    }

    @Override
    public void dressWomen() {
        //       System.out.println("Женщина надевает юбку.");
        System.out.printf("\nТип одежды: %s",
                "\nЦена: %s USD" +
                        "\nРазмер: %s." +
                        "\nЦвет: %s. ",
                name, price,
                size, color);
    }
}