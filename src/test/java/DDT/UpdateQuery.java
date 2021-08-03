package DDT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mysqltutorial.org
 */
public class UpdateQuery {

    /**
     * Update candidate demo
     */
    public static void update() {

        String sqlUpdate = "update [ebookshop].[dbo].[books]\n" +
                "  set title=?\n" +
                "  where id=?";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            conn.setAutoCommit(false);
            // prepare data for update
            String title = "Selenium";
            int id = 1001;
            pstmt.setString(1, title);
            pstmt.setInt(2, id);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

            // reuse the prepared statement
            title = "Selenide";
            id = 1002;
            pstmt.setString(1, title);
            pstmt.setInt(2, id);

            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            conn.rollback();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        update();

    }
}

