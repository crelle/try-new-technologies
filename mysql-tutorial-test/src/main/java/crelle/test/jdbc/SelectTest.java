package crelle.test.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author:crelle
 * @className:Main1
 * @version:1.0.0
 * @date:2020/9/7
 * @description:XX
 **/
public class SelectTest {

    public static void main(String[] args) {
        //
        String sql = "SELECT first_name, last_name, email " +
                "FROM candidates";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            //You need to pass the column name or column index to the getDataType() method
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                        rs.getString("last_name")  + "\t" +
                        rs.getString("email"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}