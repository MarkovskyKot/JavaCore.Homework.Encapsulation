package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Некорректное название!");
        }
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
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