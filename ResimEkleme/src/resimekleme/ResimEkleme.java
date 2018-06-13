
package resimekleme;

import java.io.*;
import java.sql.*;
import java.text.*;

/**
 *
 * @author Melda Aktepe
 */
public class ResimEkleme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection mySQLCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/dosyaekleme", "root", "");

            /**
             * @param read Dosya yolunu oku
             */
            
            File read = new File("src/resimekleme/Resources/home-office-1207834_1920.jpg");
            
            //read file
            
            FileInputStream fin = new FileInputStream(read);
           
            PreparedStatement ps =
                        mySQLCon.prepareStatement("insert into resimekleme" +
                                "(`ResimIsmi`, `Resim`)" +
                                " values(?,?)");
            
            ps.setBlob(2, fin, read.length());
            ps.setString(1,read.getName());
            int result = ps.executeUpdate();
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
