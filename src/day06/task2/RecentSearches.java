package day06.task2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RecentSearches {
    private final Deque<String> searches;
    private final int maxSize;

    public RecentSearches(int maxSize) {
        if (maxSize < 1) throw new IllegalArgumentException("Max size must be greater than 0");

        this.maxSize = maxSize;
        searches = new ArrayDeque<>();
    }

    public void add(String query) {
        if (query == null || query.isBlank())
            throw new IllegalArgumentException("Query can't be null or blank");

        searches.remove(query.trim());
        if (size() > maxSize - 1) searches.pollLast();
        searches.addFirst(query.trim());
    }

    public String getMostRecent() {
        return searches.peek();
    }

    public String getOldest() {
        return searches.peekLast();
    }

    public String removeMostRecent() {
        return searches.poll();
    }

    public List<String> getAll() {
        return new ArrayList<>(searches);
    }

    public int size() {
        return searches.size();
    }

    public boolean isEmpty() {
        return searches.isEmpty();
    }
}
