package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> productList = new LinkedList<>();

    //1. Метод добавления продукта в корзину
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Товар добавлен в корзину");
    }

    //2. Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : productList) {
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
        for (Product product : productList) {
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
        for (Product product : productList) {
            if (product != null
                    && product.getName() != null
                    && name.equalsIgnoreCase(product.getName())) {
                return true;
            }
        }
        return false;
    }

    //5. Метод очистки корзины
    public void clearBasket() {
        productList.clear();
        System.out.println("Корзина очищена");
    }

    //6.Метод удаления продукта по имени из корзины
    public List<Product> deleteProductByName(String name) {
        List<Product> deletedProducts = new ArrayList<>();

        if (name == null || name.isBlank() || productList.isEmpty()) {
            return deletedProducts;
        }

        Iterator<Product> iterator = productList.listIterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null
                    && product.getName() != null
                    && name.equalsIgnoreCase(product.getName())) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }

        return deletedProducts;
    }
}