import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Kelly Stinson
 * Course: CEN-3024C-14320 Software Development I
 * Date: 10-06-2024
 * Class: MainView
 *
 * This class represents the user interface layer (view) for the LMS system. It allows the user to
 * interact with the system, process inputs, and display results. In this initial version, it serves
 * as a command-line interface (CLI) for managing library books.
 */
public class MainView {
    private LMSController controller;
    private Scanner scanner;

    // Constructor
    public MainView(LMSController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method: showMainMenu
     * Purpose: Displays the main menu and handles user input for different operations.
     */
    public void showMainMenu() {
        String choice = "";
        while (!"7".equals(choice)) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("---------------------------------");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Check Out a Book");
            System.out.println("4. Check In a Book");
            System.out.println("5. Display Books");
            System.out.println("6. Load Books from File");
            System.out.println("7. Exit");
            System.out.println("---------------------------------");
            System.out.print("Select an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAddBookForm();
                    break;
                case "2":
                    showRemoveBookForm();
                    break;
                case "3":
                    showCheckoutBookForm();
                    break;
                case "4":
                    showCheckinBookForm();
                    break;
                case "5":
                    controller.displayBooks();
                    break;
                case "6":
                    try {
                        showLoadBooksFromFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "7":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Method: showAddBookForm
     * Purpose: Handles the process of adding a single book.
     */
    private void showAddBookForm() {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Barcode Number: ");
        String barcode = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        controller.addBook(title, author, barcode, genre);
    }

    /**
     * Method: showRemoveBookForm
     * Purpose: Handles the process of removing a book.
     */
    private void showRemoveBookForm() {
        System.out.print("Enter Barcode Number or Title of the book to remove: ");
        String identifier = scanner.nextLine();
        controller.removeBook(identifier);
    }

    /**
     * Method: showCheckoutBookForm
     * Purpose: Handles the process of checking out a book.
     */
    private void showCheckoutBookForm() {
        System.out.print("Enter Barcode Number of the book to check out: ");
        String barcode = scanner.nextLine();
        controller.checkOutBook(barcode);
    }

    /**
     * Method: showCheckinBookForm
     * Purpose: Handles the process of checking in a book.
     */
    private void showCheckinBookForm() {
        System.out.print("Enter Barcode Number of the book to check in: ");
        String barcode = scanner.nextLine();
        controller.checkInBook(barcode);
    }

    private void showLoadBooksFromFile() throws IOException {
        System.out.print("\nEnter the file including the path: ");
        String filename = scanner.nextLine();
        controller.loadBooksFromFile(filename);
    }
}
