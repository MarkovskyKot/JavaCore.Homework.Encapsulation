package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Main {
    public static void main(String[] args) {
        Product product0 = new Product("Велосипед", 36990);
        Product product1 = new Product("PS5", 75990);
        Product product2 = new Product("Фен Dyson", 69990);
        Product product3 = new Product("Смартфон", 79990);
        Product product4 = new Product("Гиря 16кг", 3050);
        Product product5 = new Product("Куртка", 14900);
        ProductBasket productBasket = new ProductBasket();

        //Добавление продукта в корзину.
        productBasket.addProduct(product0);
        productBasket.addProduct(product1);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);

        //Добавление продукта в заполненную корзину,
        //в которой нет свободного места.
        productBasket.addProduct(product2);

        //Печать содержимого корзины с несколькими товарами.
        productBasket.getProductsList();

        //Получение стоимости корзины с несколькими товарами.
        System.out.println(productBasket.getTotalCost());

        //Поиск товара, который есть в корзине.
        System.out.println(productBasket.findProductByName("PS5"));
        System.out.println(productBasket.findProductByName(product5.getName()));

        //Поиск товара, которого нет в корзине.
        System.out.println(productBasket.findProductByName(product2.getName()));

        //Очистка корзины.
        productBasket.clearBasket();

        //Печать содержимого пустой корзины.
        productBasket.getProductsList();

        //Получение стоимости пустой корзины.
        System.out.println(productBasket.getTotalCost());

        //Поиск товара по имени в пустой корзине.
        System.out.println(productBasket.findProductByName("PS5"));
        System.out.println(productBasket.findProductByName(product5.getName()));
    }
}