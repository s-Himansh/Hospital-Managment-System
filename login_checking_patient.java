import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class login_checking_patient{
    public static boolean loginnCheck(String id,String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM patientdetails WHERE USERNAME='"+id+"' AND PASSWORD='"+pass+"'");


            try {
                if (rs.next()){
                return true;
            }else{
                return false;
            }
            } catch (Exception e) {
                // TODO: handle exception
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public static int getPatientID(String id,String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM patientdetails WHERE USERNAME='"+id+"' AND PASSWORD='"+pass+"'");
            try {
                if (rs.next()){
                    return rs.getInt(1);
                }else{
                    return -1;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            rs.close();
            con.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return -1;
    }

    public static int registerDetails(String name, int age, String username, String password,String secQ,String answer){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();


            int t = smt.executeUpdate("INSERT INTO patientdetails(NAME, AGE, USERNAME, PASSWORD, SECURITY_SYMBOL, ANSWER) VALUES ('"+name+"','"+age+"','"+username+"','"+password+"','"+secQ+"','"+answer+"')");
            try {
                return t;
            } catch (Exception e) {
                // TODO: handle exception
            }

            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public static int appRegister(int pid, String name, String DOB, String address, String appDate, String appTime) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "sharma");
            String query = "INSERT INTO APPOINTMENT(ID, NAME, DOB, ADDRESS, APP_DATE, APP_TIME) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, pid);
            smt.setString(2, name);
            //as simply inserting dob and time formats is not helping , so specifying precisely date and time formats
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = dateFormat.parse(DOB);
            Date date1 = dateFormat.parse(appDate);
            Date timeDate = timeFormat.parse(appTime);
            Time time = new Time(timeDate.getTime());

            smt.setDate(3, new java.sql.Date(date.getTime()));
            smt.setString(4, address);
            smt.setDate(5, new java.sql.Date(date1.getTime()));
            smt.setTime(6, time);

            int t = smt.executeUpdate();

            // Close the prepared statement and the connection
            con.close();

            return t;
        } catch (Exception e) {
            //TODO: handle Exception
        }
        return 0;
    }

    public static int changePass(int pid, String newpass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            int t = smt.executeUpdate("UPDATE patientdetails SET PASSWORD = '"+newpass+"' WHERE PATIENT_ID = '"+pid+"' ");

            try {
                return t;
            } catch (Exception e) {
                // TODO: handle exception
            }
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }


        return 0;
    }

    public static String retrieveQuestion(String user){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM patientdetails WHERE USERNAME='"+user+"'");

            try {
                if (rs.next()){
                    return rs.getString("SECURITY_SYMBOL");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            rs.close();
            con.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

    public static String forgotCheck(String ourans,String user){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM patientdetails WHERE USERNAME='"+user+"'");

            try {
                if (rs.next()){
                    if (rs.getString("ANSWER").equals(ourans)){
                        return rs.getString("PASSWORD");
                    }
                    else{
                        return "answer is wrong";
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            rs.close();
            con.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    } 


    public static String getDoctors(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listdoctors WHERE DOCTOR_ID = '"+id+"' ");

            try {
                if (rs.next()){
                    return "Id > "+Integer.toString(rs.getInt(1))+"  "+"NAME > "+rs.getString(2)+"  "+"AGE > "+Integer.toString(rs.getInt(3))+"  "+"GENDER > "+rs.getString(4)+"  "+"USERNAME > "+rs.getString(5)+"  "+"SALARY > "+rs.getFloat(7);
                }
                else{
                    return "Sorry! No record found";
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            rs.close();
            con.close();


        } catch (Exception e) {
            // TODO: handle exception
        }

        return "";
    }

    public static String getNurses(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listnurses WHERE NURSE_ID = '"+id+"' ");

            try {
                if (rs.next()){
                    return "ID > "+Integer.toString(rs.getInt(1))+"  "+"NAME > "+rs.getString(2)+"  "+"AGE > "+Integer.toString(rs.getInt(3))+"  "+"GENDER > "+rs.getString(4)+"  "+"USERNAME > "+rs.getString(5)+"SALARY > "+rs.getFloat(7);
                }
                else{
                    return "Sorry! No record found";
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            rs.close();
            con.close();


        } catch (Exception e) {
            // TODO: handle exception
        }

        return "";
    }

    public static boolean loginCheckDoctor(String x, String y){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listdoctors WHERE USERNAME='"+x+"' AND PASSWORD='"+y+"'");
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