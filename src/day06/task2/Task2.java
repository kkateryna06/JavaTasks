package day06.task2;

public class Task2 {
    public static void main(String[] args) {
        RecentSearches recentSearches = new RecentSearches(3);
        recentSearches.add("Java");
        recentSearches.add("Spring");
        recentSearches.add("SQL");

        System.out.println(recentSearches.getAll());

        recentSearches.add("Java");
        System.out.println(recentSearches.getAll());

        recentSearches.add("Docker");
        System.out.println(recentSearches.getAll());

        System.out.println(recentSearches.getMostRecent());
        System.out.println(recentSearches.getOldest());

        recentSearches.removeMostRecent();
        System.out.println(recentSearches.getAll());

        recentSearches.add("SQL");
        System.out.println(recentSearches.getAll());

        recentSearches.removeMostRecent();
        recentSearches.removeMostRecent();

        // empty queue
        System.out.println(recentSearches.getMostRecent());
        System.out.println(recentSearches.getOldest());
        recentSearches.removeMostRecent();
        System.out.println(recentSearches.getAll());

        try {
            RecentSearches recentSearches1 = new RecentSearches(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            recentSearches.add(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            recentSearches.add(" ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
