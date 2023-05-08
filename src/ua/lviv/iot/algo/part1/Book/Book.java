import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String genre;

    public abstract int getPagesCount();

    public static void main(String[] args) {
        Book[] books = {
                new ElectronicBook("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951, "Coming-of-age fiction", "PDF", 1000000),
                new PaperBook("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1925, "Tragedy", 180, 140, 210),
                new ElectronicBook("The Lord of the Rings", "J.R.R. Tolkien", "George Allen & Unwin", 1954, "Fantasy", "EPUB", 2000000),
                new PaperBook("To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", 1960, "Southern Gothic", 281, 130, 200)
        };

        for (Book book : books) {
            System.out.println(book);
        }
    }
}

@Getter
@Setter
@ToString(callSuper=true)
public class ElectronicBook extends Book {
    private String format;
    private long fileSizeInBytes;
    private static final int BYTES_PER_PAGE_COUNT = 2048;

    public ElectronicBook(String title, String author, String publisher, int year, String genre, String format, long fileSizeInBytes) {
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setYear(year);
        setGenre(genre);
        setFormat(format);
        setFileSizeInBytes(fileSizeInBytes);
    }

    @Override
    public int getPagesCount() {
        return (int) (fileSizeInBytes / BYTES_PER_PAGE_COUNT);
    }
}

@Getter
@Setter
@ToString(callSuper=true)
public class PaperBook extends Book {
    private int pageCount;
    private int widthInMm;
    private int heightInMm;

    public PaperBook(String title, String author, String publisher, int year, String genre, int pageCount, int widthInMm, int heightInMm) {
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setYear(year);
        setGenre(genre);
        setPageCount(pageCount);
        setWidthInMm(widthInMm);
        setHeightInMm(heightInMm);
    }

    @Override
    public int getPagesCount() {
        return pageCount;
    }
}

import java.util.List;
        import java.util.ArrayList;

public class BookManager {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new ElectronicBook("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951, "Coming-of-age fiction", "PDF", 1000000));
        books.add(new PaperBook("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1925, "Tragedy", 180, 140, 210));
        books.add(new ElectronicBook("The Lord of the Rings", "J.R.R. Tolkien", "George Allen & Unwin", 1954, "Fantasy", "EPUB", 2000000));
        books.add(new PaperBook("To Kill a Mockingbird", "Harper Lee", "J. B. L
