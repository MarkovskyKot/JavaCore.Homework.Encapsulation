package org.skypro.skyshop.product;

public abstract class Product {
    protected final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract Product clone();

    public abstract int getPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();
}