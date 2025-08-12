import java.util.Scanner;

public class LoanManagementApp {
    public static void main(String[] args) {
        BorrowerDAO borrowerDAO = new BorrowerDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Loan Management System ---");
            System.out.println("1. Add Borrower");
            System.out.println("2. List Borrowers");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    borrowerDAO.addBorrower(name, phone, email);
                    break;
                case 2:
                    borrowerDAO.listBorrowers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
