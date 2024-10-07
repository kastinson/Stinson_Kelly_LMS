/**
 * Author: Kelly Stinson
 * Course: CEN-3024C-14320 Software Development I
 * Date: 10-06-2024
 * Class: LibraryManagementSystem
 *
 * This is the main class of the Library Management System (LMS)program. It sets up the necessary
 * components (model, view, and controller) and starts the application by invoking the main menu.
 *
 * Program Objective: The Library Management System (LMS) allows users to manage a collection of
 * books, with functionalities for checking books in, checking them out, and displaying available
 * books. The program follows the MVC architecture for clean separation of concerns.
 */
public class Main {
    public static void main(String[] args) {
        BookDatabase bookDatabase = new BookDatabase();
        LMSController controller = new LMSController(bookDatabase);
        MainView mainView = new MainView(controller);

        System.out.println("----------------------------------------------");
        System.out.println("Welcome to the Library Management System (LMS)");
        System.out.println("----------------------------------------------");

        mainView.showMainMenu();

        System.out.println("----------------------------");
        System.out.println("Thank you for using the LMS");
        System.out.println("----------------------------");
    }
}