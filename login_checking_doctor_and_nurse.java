
import java.awt.TextArea;
import java.sql.*;

public class login_checking_doctor_and_nurse {
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

    public static boolean loginCheckNurse(String x, String y){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listnurses WHERE USERNAME='"+x+"' AND PASSWORD='"+y+"'");
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
    public static void listappointment(TextArea values){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM appointment");
            try {
                while (rs.next()) {
                    for (int i=0;i<1;i++){
                        int appointmentId = rs.getInt("ID");
                        String name = rs.getString("NAME");
                        Date dob = rs.getDate("DOB");
                        Date appDate = rs.getDate("APP_DATE");
                        Time appTime = rs.getTime("APP_TIME");

                        values.append("\n"+"Patient ID : " + appointmentId + ",  Name : " + name +",  DOB : "+dob+",  App.Date : "+appDate+",  App. Time : "+appTime+"\n");

                        System.out.println(appointmentId + " " + name + " ");
                    }
                }
            } catch (Exception e) {}
            rs.close();
            con.close();
        } catch (Exception e) {}

    }
    public static int getRows(){
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM appointment");
            while (rs.next()){
                count++;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return count;
    }
    public static Object [][] listappointment1(int count){
        Object [][] data1 = new Object[2][6];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM appointment");
            Object [][] data = new Object[count][8];
            if (rs.next()){
                for (int i=0;i<count;i++){
                        data[i][0] = rs.getInt(1);
                        data[i][1] = rs.getString(2);
                        data[i][2] = rs.getDate(3);
                        data[i][3] = rs.getString(4);
                        data[i][4] = rs.getDate(5);
                        data[i][5] = rs.getTime(6);
                        data[i][6] = rs.getString(7);
                        data[i][7] = rs.getString(8);
                       // System.out.println(data[i][0]+" "+data[i][1]);
                       rs.next();
                    }
                }
            rs.close();
            con.close();
            return data;
        } catch (Exception e) {}

        return data1;
    }

    public static int getAssignment(int id,String name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt1 = con.createStatement();
            ResultSet rs = smt1.executeQuery("SELECT * FROM appointment WHERE ID = '"+id+"' AND ASSIGNED_NURSE IS NULL");

            if (rs.next()){
               // System.out.println("getting inside ");
                String query = "UPDATE appointment SET ASSIGNED_NURSE = ?  WHERE ID = ? ";
                PreparedStatement smt = con.prepareStatement(query);
                smt.setString(1,name);
                smt.setInt(2, id);

                int t = smt.executeUpdate();
                return t;
            }
            rs.close();
            con.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public static String getNurseName(String username,String password){
        String name="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listnurses WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"' ");
            try {
                if (rs.next()){
                name = rs.getString("NAME");
                return name;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return name;
    }
    public static int getRowsDoctors(){
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listdoctors");
            while (rs.next()){
                count++;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return count;
    }
    public static Object [][] getDoctors(int count){
        Object [][] data1 = new Object[2][6];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listdoctors");
            Object [][] data = new Object[count][6];
            if (rs.next()){
                for (int i=0;i<count;i++){
                        data[i][0] = rs.getInt(1);
                        data[i][1] = rs.getString(2);
                        data[i][2] = rs.getInt(3);
                        data[i][3] = rs.getString(4);
                        data[i][4] = rs.getString(5);
                        data[i][5] = rs.getFloat(7);
                       // System.out.println(data[i][0]+" "+data[i][1]);
                       rs.next();
                    }
                }
            rs.close();
            con.close();
            return data;
        } catch (Exception e) {}

        return data1;
    }
    public static int getRowsNurses(){
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listnurses");
            while (rs.next()){
                count++;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return count;
    }
    public static Object [][] getNurses(int count){
        Object [][] data1 = new Object[2][6];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM listnurses");
            Object [][] data = new Object[count][6];
            if (rs.next()){
                for (int i=0;i<count;i++){
                        data[i][0] = rs.getInt(1);
                        data[i][1] = rs.getString(2);
                        data[i][2] = rs.getInt(3);
                        data[i][3] = rs.getString(4);
                        data[i][4] = rs.getString(5);
                        data[i][5] = rs.getFloat(7);
                       // System.out.println(data[i][0]+" "+data[i][1]);
                       rs.next();
                    }
                }
            rs.close();
            con.close();
            return data;
        } catch (Exception e) {}

        return data1;
    }

    public static int status(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","sharma");

            String query = "UPDATE appointment SET STATUS = ? WHERE ID = ?";
                PreparedStatement smt = con.prepareStatement(query);
                smt.setString(1,"Done");
                smt.setInt(2, id);

                int t = smt.executeUpdate();
            con.close();
                return t;
            
        } catch (Exception e) {
            // TODO: handle exception
        }


        return 0;
    }


}
