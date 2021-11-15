package com.pb.petriaievB.hw7;

public abstract class Clothes {
    String name;
    Size size;
    String color;
    double price;
    public Clothes(String name, Size size, String color, double price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getSize() {
        return size + ", (евро:" + size.getEuroSize(size) + "), "
                + size.getDescription(size);
    }
    public String getColor() {
        return color;
    }
    public double getPrice() {
        return price;
    }
}