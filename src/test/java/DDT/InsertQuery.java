package DDT;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mysqltutorial.org
 */
public class InsertQuery {

    public static int insertCandidate(int id,String title,String author,
                                      int price, int qty) {
        // for insert a new candidate
        ResultSet rs = null;
        int candidateId = 0;

        String sql = " insert into [ebookshop].[dbo].[books]\n" +
                "(id,title,author,price,qty)\n" +
                "  values(?,?,?,?,?)";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            // set parameters for statement
            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setInt(4, price);
            pstmt.setInt(5, qty);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                // get id
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    candidateId = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return candidateId;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // insert a new candidate
        int id = insertCandidate(1146, "George", "Groovy",
                25, 15);

        System.out.println(String.format("A new row with id %d has been inserted.",id));
    }
}

