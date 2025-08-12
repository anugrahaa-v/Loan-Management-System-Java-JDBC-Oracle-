import java.sql.*;

public class BorrowerDAO {

    public void addBorrower(String name, String phone, String email) {
        String sql = "INSERT INTO borrowers(name, phone, email) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Borrower added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listBorrowers() {
        String sql = "SELECT borrower_id, name, phone, email FROM borrowers";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Phone: %s, Email: %s\n",
                        rs.getInt("borrower_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
