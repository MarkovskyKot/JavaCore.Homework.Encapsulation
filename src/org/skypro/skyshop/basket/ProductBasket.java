package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    //1. Метод добавления продукта в корзину
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product.clone();
                System.out.println("Товар добавлен в корзину");
                return;
            }
        }
        System.out.println("Невозможно добавить товар: в корзине нет места.");
    }

    //2. Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    //3. Метод, который печатает содержимое корзины, с проверкой на пустоту
    public void getProductsList() {
        boolean isEmpty = true;
        int specialCounter = 0;
        for (Product product : products) {
            if (product != null) {
                isEmpty = false;
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCounter++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalCost() + "₽");
            System.out.println("Специальных товаров: " + specialCounter);
        }
    }

    //4. Метод, проверяющий продукт в корзине по имени
    public boolean findProductByName(String name) {
        if (name == null) return false;
        String nameLC = name.toLowerCase();
        for (Product product : products) {
            if (product != null
                    && product.getName() != null
                    && nameLC.equals(product.getName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    //5. Метод очистки корзины
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println("Корзина очищена");
    }
}