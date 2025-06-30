package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final double discount;

    public DiscountedProduct(String name, int basicPrice, double discount) {
        super(name);
        this.basicPrice = basicPrice;
        this.discount = discount;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    @Override
    public int getPrice() {
        return (int) (basicPrice * (1 - discount / 100));
    }

    @Override
    public Product clone() {
        return new DiscountedProduct(this.name, this.basicPrice, this.discount);
    }

    @Override
    public String toString() {
        return name + ": " + getPrice() + "₽" + " (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
