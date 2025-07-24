package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchableList = new LinkedList<>();

    public void add(Searchable item) {
        searchableList.add(item);
        System.out.println("*Объект добавлен*\n");
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchableList) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable getBestSearchable(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty() || searchableList.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestResult = null;
        int maxCount = 0;
        String searchLower = search.toLowerCase();

        for (Searchable s : searchableList) {
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
