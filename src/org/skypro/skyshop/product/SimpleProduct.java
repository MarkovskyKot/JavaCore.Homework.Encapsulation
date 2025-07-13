package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Неверная цена!");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Product clone() {
        return new SimpleProduct(this.name, this.price);
    }

    @Override
    public String toString() {
        return name + ": " + price + "₽";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
