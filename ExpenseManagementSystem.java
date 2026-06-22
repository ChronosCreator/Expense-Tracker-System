import java.util.Scanner;

public class ExpenseManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1.Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3.Search Category");
            System.out.println("4. Total Expenses");
            System.out.println("5. Delete Expenses");
            System.out.println("6.Exit");
            System.out.println("Enter Choice");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter ID");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Category");
                    String category = sc.nextLine();
                    System.out.println("Enter Description:");
                    String description = sc.nextLine();

                    System.out.println("Enter Amount:");
                    double amount = sc.nextDouble();
                    dao.addExpense(id,
                            category,
                            description,
                            amount);

                    break;
                case 2:
                    dao.viewExpenses();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Category");
                    String search = sc.nextLine();
                    dao.searchExpense(search);
                    break;
                case 4:
                    dao.totalExpenses();
                    break;
                case 5:
                    System.out.println("Enter expense ID:");
                    int deleteId = sc.nextInt();
                    dao.deleteExpense(deleteId);
                    break;

                case 6:
                    System.out.println("THANK YOU!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invaild Choice !");

            }
        }
    }
}