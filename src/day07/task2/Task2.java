package day07.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public record BookInfo(
            String title,
            String author,
            int pages,
            double rating
    ) { }

    public static class BookAnalytics {
        public static List<String> findRecommendedTitles(
                List<BookInfo> books,
                int minimumPages,
                double minimumRating
        ) {
            if (books == null) throw new IllegalArgumentException("Books can't be null");
            if (minimumPages < 0) throw new IllegalArgumentException("Pages count can't be negative");
            if (minimumRating < 0) throw new IllegalArgumentException("Rating can't be negative");
            if (books.stream().anyMatch(bookInfo -> bookInfo == null)) {
                throw new IllegalArgumentException("Books can't contain null");
            }

            List<String> titles = books.stream()
                    .filter(bookInfo ->
                            bookInfo.pages() >= minimumPages && bookInfo.rating() >= minimumRating)
                    .sorted(Comparator.comparingDouble(BookInfo::rating).reversed()
                            .thenComparing(BookInfo::title))
                    .map(bookInfo -> bookInfo.title())
                    .toList();

            return titles;
        }

        public static double calculateAveragePages(List<BookInfo> books) {
            if (books == null) throw new IllegalArgumentException("Books can't be null");
            if (books.stream().anyMatch(bookInfo -> bookInfo == null)) {
                throw new IllegalArgumentException("Books can't contain null");
            }

            double averagePages = books.stream()
                    .mapToInt(bookInfo -> bookInfo.pages())
                    .average()
                    .orElse(0);

            return averagePages;
        }
    }

    public static void main(String[] args) {
        List<BookInfo> books = List.of(
                new BookInfo("1984", "George Orwell", 328, 4.6),
                new BookInfo("The Hobbit", "J.R.R. Tolkien", 310, 4.8),
                new BookInfo("The Little Prince", "Antoine de Saint-Exupéry", 96, 4.7),
                new BookInfo("Dune", "Frank Herbert", 688, 4.6),
                new BookInfo("Pride and Prejudice", "Jane Austen", 432, 4.4),
                new BookInfo("The Shining", "Stephen King", 447, 4.3)
        );

        System.out.println(BookAnalytics.findRecommendedTitles(books, 310, 4.4));
        System.out.println(BookAnalytics.calculateAveragePages(books));

        System.out.println(BookAnalytics.findRecommendedTitles(books, 500, 5));
        System.out.println(BookAnalytics.calculateAveragePages(new ArrayList<>()));

        try {
            BookAnalytics.findRecommendedTitles(null, 100, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            BookAnalytics.findRecommendedTitles(books, -1, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            BookAnalytics.findRecommendedTitles(books, 100, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<BookInfo> bookInfos = new ArrayList<>();
            bookInfos.add(null);
            BookAnalytics.findRecommendedTitles(bookInfos, 100, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            BookAnalytics.calculateAveragePages(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<BookInfo> bookInfos = new ArrayList<>();
            bookInfos.add(null);
            BookAnalytics.calculateAveragePages(bookInfos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
