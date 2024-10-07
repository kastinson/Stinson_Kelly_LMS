import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Author: Kelly Stinson
 * Course: CEN-3024C-14320 Software Development I
 * Date: 10-06-2024
 * Class: Book
 *
 * This class represents a book in the library system. Each book object will have a title,
 * author, barcode number, genre, status (checked in or out), and due date (if applicable).
 * The class also provides necessary methods to manage the book's attributes.
 */
public class Book {
    private String title;
    private String author;
    private String barcodeNumber;
    private String genre;
    private String status; // "Checked In", "Checked Out"
    private String dueDate;

    // Constructor
    public Book(String title, String author, String barcodeNumber, String genre, String status, String dueDate) {
        this.title = title;
        this.author = author;
        this.barcodeNumber = barcodeNumber;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getBarcodeNumber() { return barcodeNumber; }
    public void setBarcodeNumber(String barcodeNumber) { this.barcodeNumber = barcodeNumber; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    /**
     * Method: checkOut
     * Purpose: Changes the status of the book to "Checked Out" and assigns a due date.
     */
    public void checkOut() {
        if ("Checked In".equals(status)) {
            this.status = "Checked Out";
            // Get today's date
            LocalDate today = LocalDate.now();

            // Add 4 weeks to today's date
            LocalDate newDate = today.plusWeeks(4);

            // Define the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Format the new date back to string
            this.dueDate = newDate.format(formatter);
            System.out.println("Book checked out. Due: " + dueDate);
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    /**
     * Method: checkInBook
     * Purpose: Changes the status of the book to "Checked In" and clears the due date.
     */
    public void checkIn() {
        if ("Checked Out".equals(status)) {
            this.status = "Checked In";
            this.dueDate = null;
            System.out.println("Book checked in.");
        } else {
            System.out.println("Book is already checked in.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", barcodeNumber='" + barcodeNumber + '\'' +
                ", genre='" + genre + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + (dueDate != null ? dueDate : "N/A") +
                '}';
    }
}
