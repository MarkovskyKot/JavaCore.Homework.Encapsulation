package org.skypro.skyshop;

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

        //Демонстрация проверки данных
        try {
            product0 = new SimpleProduct("PS5", 75990);
            System.out.println("Объект создан");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

        try {
            product1 = new SimpleProduct("   ", 69990);
            System.out.println("Объект создан");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

        try {
            product2 = new SimpleProduct("Смартфон infinix", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

        try {
            product3 = new DiscountedProduct("Велосипед HOT WOLF", 36990, 300);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
        }

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

        System.out.println(article0);
        System.out.println(article1);

        SearchEngine engine = new SearchEngine(20);
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
    }
}