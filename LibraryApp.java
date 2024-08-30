package ADT;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Book by Index");
            System.out.println("4. Display All Books");
            System.out.println("5. Total Number of Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    library.addBook(bookName);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter index of book to remove: ");
                    int removeIndex = scanner.nextInt();
                    try {
                        library.removeBook(removeIndex);
                        System.out.println("Book removed successfully.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    System.out.print("Enter index of book to view: ");
                    int viewIndex = scanner.nextInt();
                    try {
                        System.out.println("Book at index " + viewIndex + ": " + library.getBook(viewIndex));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Total number of books: " + library.getTotalBooks());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

