package DDT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class Procedure {

    public static void getSkills(int bookId) {
        //
        String query = "{ call getBookById(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection();
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, bookId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s - %s",
                        rs.getString("title") + " "
                                + rs.getString("author"),
                        rs.getString("qty")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        getSkills(1001);
    }
}

