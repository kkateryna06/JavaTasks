package day04.task3;

import java.util.Objects;

public final class Book {
    private final String isbn;
    private final String title;
    private final String author;

    Book(String isbn, String title, String author) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN can't be null or blank");
        } else if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title can't be null or blank");
        } else if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author can't be null or blank");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object == this) return true;
        if (!(object instanceof Book book)) return false;

        return book.isbn.equals(this.isbn);
    }
}
