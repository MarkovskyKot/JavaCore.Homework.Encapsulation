package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class Main {
    public static void main(String[] args) {
        Product product0 = new SimpleProduct("PS5", 75990);
        Product product1 = new SimpleProduct("Фен Dyson", 69990);
        Product product2 = new SimpleProduct("Смартфон", 79990);
        Product product3 = new DiscountedProduct("Велосипед", 36990, 20);
        Product product4 = new DiscountedProduct("Куртка", 14900, 30);
        Product product5 = new FixPriceProduct("Набор кухонных ножей");
        Product product6 = new FixPriceProduct("Набор инструментов");
        ProductBasket productBasket = new ProductBasket();

        //Добавление продукта в корзину.
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);

        //Добавление продукта в заполненную корзину,
        //в которой нет свободного места.
        productBasket.addProduct(product1);

        //Печать содержимого корзины с несколькими товарами.
        productBasket.getProductsList();

        //Получение стоимости корзины с несколькими товарами.
        System.out.println(productBasket.getTotalCost());

        //Поиск товара, который есть в корзине.
        System.out.println(productBasket.findProductByName("Велосипед"));
        System.out.println(productBasket.findProductByName(product5.getName()));

        //Поиск товара, которого нет в корзине.
        System.out.println(productBasket.findProductByName(product0.getName()));

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