package crelle.test.jdbc;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author:crelle
 * @className:WriteBlobTest
 * @version:1.0.0
 * @date:2020/9/7
 * @description:XX
 **/
public class WriteBlobTest {

    /**
     * Update resume for a specific candidate
     *
     * @param candidateId
     * @param filename
     */
    public static void writeBlob(int candidateId, String filename) {
        // update sql
        String updateSQL = "UPDATE candidates "
                + "SET resume = ? "
                + "WHERE id=?";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // read the file
            File file = new File(filename);
            FileInputStream input = new FileInputStream(file);

            // set parameters
            pstmt.setBinaryStream(1, input);
            pstmt.setInt(2, candidateId);

            // store the resume file in database
            System.out.println("Reading file " + file.getAbsolutePath());
            System.out.println("Store file in the database.");
            pstmt.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        writeBlob(141, "d:/johndoe_resume.pdf");

    }

}
