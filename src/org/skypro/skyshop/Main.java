package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class Main {
    public static void main(String[] args) {
        Product product0 = null;
        Product product1 = null;
        Product product2 = null;
        Product product3 = null;
        Product product4 = new DiscountedProduct("Куртка", 14900, 20);
        Product product5 = new FixPriceProduct("Набор кухонных ножей");
        Product product6 = new FixPriceProduct("Набор инструментов");
        Product product7 = new DiscountedProduct("Куртка", 18900, 15);
        Product product8 = new DiscountedProduct("Куртка", 9900, 10);
        Product product9 = new DiscountedProduct("Куртка", 34900, 25);

        //Демонстрация проверки данных
        try {
            product0 = new SimpleProduct("PS5", 75990);
            System.out.println("Объект создан");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

        try {
            product1 = new SimpleProduct("Фен Dyson", 69990);
            System.out.println("Объект создан");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

        try {
            product2 = new SimpleProduct("Смартфон infinix", 15990);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

        try {
            product3 = new DiscountedProduct("Велосипед HOT WOLF", 36990, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(product0);
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);
        productBasket.addProduct(product7);
        productBasket.addProduct(product8);
        productBasket.addProduct(product9);
        System.out.println(productBasket.findProductByName("куртка"));
        System.out.println();
        productBasket.getProductsList();
        System.out.println();
        System.out.println(productBasket.deleteProductByName("курТка"));
        System.out.println();
        productBasket.getProductsList();
        System.out.println();
        System.out.println(productBasket.deleteProductByName("куртка"));
        System.out.println();
        productBasket.getProductsList();
        productBasket.clearBasket();
        productBasket.getProductsList();




        Article article0 = new Article("Обзор PlayStation 5", "Могу ли я рекомендовать PS5 к покупке?" +
                " Скорее да, чем нет." +
                " Но при условии, что вы любите играть" +
                " и вам интересны в первую очередь эксклюзивы...");
        Article article1 = new Article("Обзор на фен Dyson", "Фен Dyson, в частности модель Supersonic, " +
                "это высокотехнологичный прибор для укладки волос, " +
                "который выделяется среди прочих фенов " +
                "благодаря своей инновационной конструкции и интеллектуальным функциям...");
        Article article2 = new Article("infinix hot 40 pro", "Шустрый телефон. " +
                "В игрушках себя показывает бодро. Обнова сразу прилетает...");
        Article article3 = new Article("Описание велосипеда HOT WOLF", "Оснащенный амортизационной вилкой, " +
                "удобным рулем и сидением с обивкой из искусственной кожи, " +
                "а также дисковыми тормозами и полуинтегрированной рулевой колонкой...");
        Article article4 = new Article("Описание куртки", "Куртка кожаная, " +
                "с металлическими вставками, заклёпками, цепями, шипами. " +
                "Самое то для поклонников тяжёлой музыки...");
        Article article5 = new Article("Комплектация набора",
                "*Список ножей входящих в набор, описание, характеристики...*");
        Article article6 = new Article("Комплектация набора",
                "*Список инструментов входящих в набор, описание, характеристики...*");
        System.out.println();

        SearchEngine engine = new SearchEngine();
        engine.add(product0);
        engine.add(article0);
        engine.add(product1);
        engine.add(article1);
        engine.add(product2);
        engine.add(article2);
        engine.add(product3);
        engine.add(article3);
        engine.add(product4);
        engine.add(article4);
        engine.add(product5);
        engine.add(article5);
        engine.add(product6);
        engine.add(article6);
        engine.add(product7);
        engine.add(product8);
        engine.add(product9);

        //Демонстрация обновлённого метода search
        System.out.println(engine.search("т"));
        System.out.println();

        //Демонстрация нового метода поиска
        try {
            Searchable result = engine.getBestSearchable("Куртка");
            System.out.println("Найден наиболее подходящий результат: " + result.getStringRepresentation() + "\n" + result);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable result = engine.getBestSearchable("То");
            System.out.println("Найден наиболее подходящий результат: " + result.getStringRepresentation() + "\n" + result);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable result = engine.getBestSearchable("Xnj");
            System.out.println("Найден наиболее подходящий результат: " + result.getStringRepresentation() + "\n" + result);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        productBasket.addProduct(product0);
        productBasket.addProduct(product5);
        productBasket.addProduct(product3);
        System.out.println("TotalCost = " + productBasket.getTotalCost());
    }
}