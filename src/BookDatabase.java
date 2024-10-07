import java.io.*;
import java.util.*;

/**
 * Author: Kelly Stinson
 * Course: CEN-3024C-14320 Software Development I
 * Date: 10-06-2024
 * Class: BookDatabase
 *
 * This class manages the collection of books in the library system. A CSV file is used to initial load the list
 * and there are methods to add, remove, check out, and check in books. This class acts as the model in the MVC
 * architecture.
 */
public class BookDatabase {
    private List<Book> books;

    // Constructor
    public BookDatabase() {
        this.books = new ArrayList<>();
    }

    /**
     * Method: loadBooksFromFile
     * Purpose: Loads books from a CSV file into the book list.
     * @param filePath The file path and name of the CSV file to load books from.
     * @throws IOException If the file cannot be read.
     */
    public void loadBooksFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String title = data[0];
            String author = data[1];
            String barcode = data[2];
            String genre = data[3];
            String status = data[4];
            String dueDate = data.length > 5 ? data[5] : null;
            books.add(new Book(title, author, barcode, genre, status, dueDate));
        }
        br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Method: addBook
     * Purpose: Adds a new book to the library's collection.
     * @param book The book object to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the database by either its barcode or title.
     *
     * @param identifier The book's barcode or title as a string.
     */
    public void removeBook(String identifier) {
        // First attempt to remove the book by barcode
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            // If identifier matches the barcode, remove the book
            if (book.getBarcodeNumber().equals(identifier)) {
                books.remove(i);
                System.out.println("Book with barcode " + identifier + " has been removed.");
                return;
            }
        }

        // If no book was found by barcode, try to remove it by title
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            // If identifier matches the title, remove the book
            if (book.getTitle().equalsIgnoreCase(identifier)) {
                books.remove(i);
                System.out.println("Book with title '" + identifier + "' has been removed.");
                return;
            }
        }

        // If no match is found by either barcode or title
        System.out.println("No book found with barcode or title: " + identifier);
    }

    /**
     * Method: checkOutBook
     * Purpose: Checks out a book from the collection using its barcode number.
     * @param barcodeNumber The barcode number of the book to be removed.
     */
    public void checkOutBook(String barcodeNumber) {
        Optional<Book> book = books.stream()
                .filter(b -> b.getBarcodeNumber().equals(barcodeNumber))
                .findFirst();
        book.ifPresent(Book::checkOut);
    }

    /**
     * Method: checkInBook
     * Purpose: Checks in a book to the collection using its barcode number.
     * @param barcodeNumber The barcode number of the book to be removed.
     */
    public void checkInBook(String barcodeNumber) {
        Optional<Book> book = books.stream()
                .filter(b -> b.getBarcodeNumber().equals(barcodeNumber))
                .findFirst();
        book.ifPresent(Book::checkIn);
    }

    /**
     * Method: displayBooks
     * Purpose: Displays the current list of books.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\nCurrent Collection:\n");
            books.forEach(System.out::println);
        }
    }
}
