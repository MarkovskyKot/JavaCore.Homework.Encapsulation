package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex++] = item;
            System.out.println("*Объект добавлен*\n");
        } else {
            System.out.println("Больше нельзя добавить\n");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[foundCount++] = item;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable getBestSearchable(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestResult = null;
        int maxCount = 0;
        String searchLower = search.toLowerCase();

        for (Searchable s : searchables) {
            if (s == null || s.getSearchTerm() == null) {
                continue;
            }

            String str = s.getSearchTerm().toLowerCase();
            int count = 0;
            int index = 0;
            int indexSubstring;
            while ((indexSubstring = str.indexOf(searchLower, index)) != -1) {
                count++;
                index = indexSubstring + search.length();
            }

            if (count > maxCount) {
                maxCount = count;
                bestResult = s;
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }
}
