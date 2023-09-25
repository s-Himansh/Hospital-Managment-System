import java.sql.*;

public class login_checking_admin {
    public static boolean loginCheck(String x,String y){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM AdminDetails WHERE ID='"+x+"' AND PASSWORD='"+y+"'");
            try {
                if (rs.next()){
                    return true;
                }
                else {
                    return false;
                }
            } catch (Exception e) {
            }
            rs.close();
            con.close();
        } catch (Exception e) {}

        return false;
    } 
}
