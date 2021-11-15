package com.pb.petriaievB.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie() {
        super("Галстук", Size.XXS, "Голубой", 99.95);
    }

    @Override
    public void dressMan() {
        //    System.out.println("Мужчина надевает галстук.");
        System.out.printf("\nТип одежды: %s",
                "\nЦена: %s USD" +
                        "\nРазмер: %s." +
                        "\nЦвет: %s. ",
                name, price,
                size, color);
    }
}