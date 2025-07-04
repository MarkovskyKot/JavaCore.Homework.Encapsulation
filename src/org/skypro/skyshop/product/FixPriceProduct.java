package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 990;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public Product clone() {
        return new FixPriceProduct(this.name);
    }

    @Override
    public String toString() {
        return name + ": фикс. цена - " + FIX_PRICE + "₽";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
