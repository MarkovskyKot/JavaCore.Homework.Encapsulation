package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productMap = new TreeMap<>();

    //1. Метод добавления продукта в корзину
    public void addProduct(Product product) {
        if (product == null || product.getName() == null) {
            return;
        }
        String name = product.getName().toLowerCase();
        productMap.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
        System.out.println("Товар добавлен в корзину");
    }

    //2. Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (List<Product> products : productMap.values()) {
            for (Product product : products) {
                if (product != null) {
                    totalCost += product.getPrice();
                }
            }
        }
        return totalCost;
    }

    //3. Метод, который печатает содержимое корзины, с проверкой на пустоту
    public void getProductsList() {
        if (productMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        //Печать товаров по категориям (в перспективе на расширение магазина)
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
            String name = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.println("=== " + name + " ===");
            for (Product product : products) {
                System.out.println(product);
            }
        }

        //Подсчёт спецтоваров
        int specialCounter = 0;
        for (List<Product> products : productMap.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    specialCounter++;
                }
            }
        }

        System.out.println("Итого: " + getTotalCost() + "₽");
        System.out.println("Специальных товаров: " + specialCounter);
    }

    //4. Метод, проверяющий продукт в корзине по имени
    public boolean findProductByName(String name) {
        return name != null && productMap.containsKey(name.toLowerCase());
    }

    //5. Метод очистки корзины
    public void clearBasket() {
        productMap.clear();
        System.out.println("Корзина очищена");
    }

    //6.Метод удаления продукта по имени из корзины
    public List<Product> deleteProductByName(String name) {
        if (name == null || name.isBlank()) {
            return Collections.emptyList();
        }
        List<Product> deletedProducts = productMap.remove(name.toLowerCase());
        return deletedProducts != null ? deletedProducts : Collections.emptyList();
    }
}