package day04.task3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        Book book1 = new Book("978-0141439600", "A Tale of Two Cities", "Charles Dickens");
        Book book2 = new Book("978-0156012195", "The Little Prince", "Antoine de Saint-Exupéry");
        Book book3 = new Book("978-0141439600", "The Alchemist", "Paulo Coelho");
        Book book4 = new Book("978-0141439600", "And Then There Were None", "Agatha Christie");

        Set<Book> books = new HashSet<>();

        System.out.println(book1 == book3);
        System.out.println(book1.equals(book3));

        System.out.println(book1.equals(book1));

        System.out.println(Objects.hashCode(book1));
        System.out.println(Objects.hashCode(book3));

        System.out.println(book3.equals(book1));

        System.out.println(book1.equals(book3));
        System.out.println(book3.equals(book4));
        System.out.println(book1.equals(book4));

        System.out.println(book1.equals(null));

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        System.out.println(books.size());
        System.out.println(books.contains(book2));
    }
}
