package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

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
        if (query == null || query.isEmpty()) {
            return new TreeSet<>(comparator);
        }
        String queryLower = query.toLowerCase();
        return searchableSet.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getSearchTerm() != null)
                .filter(item -> item.getSearchTerm().toLowerCase().contains(queryLower))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
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
