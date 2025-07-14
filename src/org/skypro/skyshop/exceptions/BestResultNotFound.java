package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("Результат не найден для запроса: " + searchQuery);
    }
}
