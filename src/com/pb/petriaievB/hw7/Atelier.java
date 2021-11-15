package com.pb.petriaievB.hw7;

public class Atelier {
    public static void dressMan(Clothes[] clothes) {
        for (Clothes cloth : clothes) {
            if (cloth instanceof ManClothes) {
                System.out.println("\nТип одежды: " + cloth.getName() +
                        "\nЦена: " + cloth.getPrice() + " USD" +
                        "\nРазмер: " + cloth.getSize() +
                        "\nЦвет: " + cloth.getColor());
            }
        }
    }
    public static void dressWomen(Clothes[] clothes) {
        for (Clothes cloth : clothes) {
            if (cloth instanceof WomenClothes) {
                System.out.println("\nТип одежды: " + cloth.getName() +
                        "\nЦена: " + cloth.getPrice() + " USD" +
                        "\nРазмер: " + cloth.getSize() +
                        "\nЦвет: " + cloth.getColor());
            }
        }
    }
    public static void main(String[] args) {
        Clothes tshirt = new Tshirt();
        Clothes tie = new Tie();
        Clothes pants = new Pants();
        Clothes skirt = new Skirt();
        Clothes[] collection = {tshirt, tie, pants, skirt};
        System.out.println("Мужская коллекция: ");
        dressMan(collection);
        System.out.println();
        System.out.println("Женская коллекция: ");
        dressWomen(collection);
    }
}
