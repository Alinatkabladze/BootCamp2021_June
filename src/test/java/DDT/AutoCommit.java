package DDT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutoCommit {
    public static void executeWithAutoCommitFalse() {
        String sqlUpdate = "update [ebookshop].[dbo].[books]\n" +
                "  set title='Selenium'\n" +
                "  where id=1001";

        try (
                Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            conn.setAutoCommit(false);
            int rowAffected = pstmt.executeUpdate();
            conn.commit();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        executeWithAutoCommitFalse();
    }
}