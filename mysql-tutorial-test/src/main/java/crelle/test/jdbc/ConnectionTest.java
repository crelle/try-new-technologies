package crelle.test.jdbc;



import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:crelle
 * @className:Main
 * @version:1.0.0
 * @date:2020/9/7
 * @description:XX
 **/
public class ConnectionTest {

    public static void main(String[] args) {
        // create a new connection from MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            // print out a message
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}