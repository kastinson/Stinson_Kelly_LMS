import java.io.IOException;

/**
 * Author: Kelly Stinson
 * Course: CEN-3024C-14320 Software Development I
 * Date: 10-06-2024
 * Class: LMSController
 *
 * This class serves as the controller in the MVC architecture. It mediates between the view and
 * the model, processing user input and updating the model or view accordingly.
 */
public class LMSController {
    private BookDatabase bookDatabase;

    // Constructor
    public LMSController(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    /**
     * Method: addBook
     * Purpose: Adds a single book to the Book Database
     */
    public void addBook(String title, String author, String barcode, String genre) {
        Book newBook = new Book(title, author, barcode, genre, "Checked In", null);
        bookDatabase.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    /**
     * Method: removeBook
     * Purpose: Removes a single book from the Book Database
     * @param identifier The barcode or title of the book to remove.
     */
    public void removeBook(String identifier) {
        bookDatabase.removeBook(identifier);
        //System.out.println("Book removed successfully.");
    }

    /**
     * Method: checkOutBook
     * Purpose: Checks out a book and assigns a due date.
     * @param barcode The barcode of the book to check out.
     */
    public void checkOutBook(String barcode) {
        bookDatabase.checkOutBook(barcode);
    }

    /**
     * Method: checkInBook
     * Purpose: Checks in a book and clears the due date.
     * @param barcode The barcode number of the book to check in.
     */
    public void checkInBook(String barcode) {
        bookDatabase.checkInBook(barcode);
    }

    /**
     * Method: loadBooksFromFile
     * Purpose: Load Books Database from csv file
     * @param filePath The path and filename for the csv file to be loaded.
     */
    public void loadBooksFromFile(String filePath) throws IOException {
        bookDatabase.loadBooksFromFile(filePath);
    }

    /**
     * Method: displayBooks
     * Purpose: Displays the books in the Book Database.
     */
    public void displayBooks() {
        bookDatabase.displayBooks();
    }
}
