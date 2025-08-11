package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableSet = new HashSet<>();
    private static final Comparator<Searchable> LENGTH_THEN_NATURAL_ORDER= (s1, s2) -> {
        int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
        return lengthCompare != 0 ? lengthCompare : s1.getName().compareTo(s2.getName());
    };

    public void add(Searchable item) {
        if (item != null) {
            searchableSet.add(item);
            System.out.println("*Объект добавлен*\n");
        }
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> resultMap = new TreeSet<>(LENGTH_THEN_NATURAL_ORDER);

        if (query == null || query.isEmpty()) {
            return resultMap;
        }
        String queryLower = query.toLowerCase();
        for (Searchable item : searchableSet) {
            if (item != null
                    && item.getSearchTerm() != null
                    && item.getSearchTerm().toLowerCase().contains(queryLower)) {
                    resultMap.add(item);
            }
        }
        return resultMap;
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
