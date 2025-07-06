package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = item;
            System.out.println("*Объект добавлен*\n");
            currentIndex++;
        } else {
            System.out.println("Больше нельзя добавить\n");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[foundCount] = item;
                foundCount++;
                if (foundCount == 5) break;
            }
        }
        return results;
    }
}
