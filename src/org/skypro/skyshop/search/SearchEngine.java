package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchableList = new LinkedList<>();

    public void add(Searchable item) {
        searchableList.add(item);
        System.out.println("*Объект добавлен*\n");
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> resultMap = new TreeMap<>();

        if (query == null || query.isEmpty()) {
            return resultMap;
        }
        String queryLower = query.toLowerCase();
        for (Searchable item : searchableList) {
            if (item != null && item.getSearchTerm() != null && item.getSearchTerm().toLowerCase().contains(queryLower)) {
                if (!resultMap.containsKey(item.getName())) {
                    resultMap.put(item.getName(), item);
                }
            }
        }
        return resultMap;
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
