package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {
    private final String title;
    private final int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return String.format("%s (%d pages)", title, pages);
    }
}

public class ComparatorChainingExample {
    static void main() {
        List<Book> books = Arrays.asList(
                new Book("The Catcher in the Rye", 112),
                new Book("To Kill a Mockingbird", 281),
                new Book("1984", 328),
                new Book("The Great Gatsby", 180),
                new Book("Brave New World", 268),
                new Book("The Hobbit", 310),
                new Book("Animal Farm", 112),
                new Book("Fahrenheit 451", 158),
                new Book("The Alchemist", 180)
        );

        books.sort(Comparator.comparingInt(Book::getPages).thenComparing(Comparator.comparing(Book::getTitle)));

        System.out.println("The Sorting for book based on Page then and Alphabatically orders");
        books.forEach(System.out::println);
    }
}
