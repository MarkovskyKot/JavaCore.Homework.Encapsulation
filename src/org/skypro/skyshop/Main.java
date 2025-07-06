package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class Main {
    public static void main(String[] args) {
        Product product0 = new SimpleProduct("PS5", 75990);
        Product product1 = new SimpleProduct("Фен Dyson", 69990);
        Product product2 = new SimpleProduct("Смартфон infinix", 79990);
        Product product3 = new DiscountedProduct("Велосипед HOT WOLF", 36990, 30);
        Product product4 = new DiscountedProduct("Куртка", 14900, 20);
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
        System.out.println(productBasket.findProductByName("Велосипед HOT WOLF"));
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

        Article article0 = new Article("Обзор PlayStation 5", "Могу ли я рекомендовать PS5 к покупке?" +
                " Скорее да, чем нет." +
                " Но при условии, что вы любите играть" +
                " и вам интересны в первую очередь эксклюзивы...");
        Article article1 = new Article("Обзор на фен Dyson", "Фен Dyson, в частности модель Supersonic, " +
                "это высокотехнологичный прибор для укладки волос, " +
                "который выделяется среди прочих фенов " +
                "благодаря своей инновационной конструкции и интеллектуальным функциям...");
        System.out.println();

        System.out.println(article0);
        System.out.println(article1);

        SearchEngine engine = new SearchEngine(20);
        engine.add(product0);
        engine.add(article0);
        engine.add(product1);
        engine.add(article1);
        engine.add(product2);
        engine.add(new Article("infinix hot 40 pro", "Шустрый телефон. " +
                "В игрушках себя показывает бодро. Обнова сразу прилетает..."));
        engine.add(product3);
        engine.add(new Article("Описание велосипеда HOT WOLF", "Оснащенный амортизационной вилкой, " +
                "удобным рулем и сидением с обивкой из искусственной кожи, " +
                "а также дисковыми тормозами и полуинтегрированной рулевой колонкой..."));
        engine.add(product4);
        engine.add(new Article("Описание куртки", "Куртка кожаная, " +
                "с металлическими вставками, заклёпками, цепями, шипами. " +
                "Самое то для поклонников тяжёлой музыки..."));
        engine.add(product5);
        engine.add(new Article("Комплектация набора",
                "*Список ножей входящих в набор, описание, характеристики...*"));
        engine.add(product6);
        engine.add(new Article("Комплектация набора",
                "*Список инструментов входящих в набор, описание, характеристики...*"));

        Searchable[] results0 = engine.search("о");

        for (Searchable item : results0) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println();

        Searchable[] results1 = engine.search("к");

        for (Searchable item : results1) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println();

        Searchable[] results2 = engine.search("набор");

        for (Searchable item : results2) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
}