package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableSet = new HashSet<>();
    private final Comparator<Searchable> comparator = new SearchableComparator();

    public void add(Searchable item) {
        if (item != null) {
            searchableSet.add(item);
            System.out.println("*Объект добавлен*\n");
        }
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> resultSet = new TreeSet<>(comparator);

        if (query == null || query.isEmpty()) {
            return resultSet;
        }
        String queryLower = query.toLowerCase();
        for (Searchable item : searchableSet) {
            if (item != null
                    && item.getSearchTerm() != null
                    && item.getSearchTerm().toLowerCase().contains(queryLower)) {
                    resultSet.add(item);
            }
        }
        return resultSet;
    }

    public Searchable getBestSearchable(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty() || searchableSet.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestResult = null;
        int maxCount = 0;
        String searchLower = search.toLowerCase();

        for (Searchable s : searchableSet) {
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
