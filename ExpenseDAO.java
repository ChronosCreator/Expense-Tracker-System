import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseDAO {
    public void addExpense(int id,
            String category,
            String description,
            double amount) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "INSERT INTO expenses VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, category);
            ps.setString(3, description);
            ps.setDouble(4, amount);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Expense added Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void viewExpenses() {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM expenses";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("category") + " "
                                + rs.getString("description") + " "
                                + rs.getDouble("amount"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void searchExpense(String category) {
        try {

            Connection con = DatabaseConnection.getConnection();

            String query = "SELECT * FROM expenses WHERE category = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();
            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("category") + " "
                                + rs.getString("description") + " "
                                + rs.getDouble("amount"));

            }
            if (!found) {
                System.out.println("NO expense found.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void totalExpenses() {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT SUM(amount) AS total FROM expenses";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        "Total Expenses = "
                                + rs.getDouble("total"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteExpense(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "DELETE FROM expenses WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Expense not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
