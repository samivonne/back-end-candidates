package heb.Request;
import java.sql

public class All_Candidate
{
    public static void main (String[] args) {
        try {
            //String url = "jdbc:msql://200.210.220.1:1114/Demo";
            Connection conn = DriverManager.getConnection(url,"","");
            Statement stmt = conn.createStatement();
            ResultSet rs;
 
            rs = stmt.executeQuery("SELECT * FROM candidate ");
            while ( rs.next() ) {
                String everything = rs.getString("*");
                System.out.println(everything);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}