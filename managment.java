import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class managment extends Frame implements ActionListener {
    Button button_start;
    public managment() {
        button_start = new Button("Start");

        setLayout(null);
        add(button_start);
        button_start.setBounds(700, 450, 150, 50);

        button_start.addActionListener(this);
        addWindowListener(new close(this));
    }

    public void actionPerformed(ActionEvent ae) {
        admin_client s1 = new admin_client();
        s1.setSize(1900, 900);
        s1.setVisible(true);

        dispose();
    }

    public static void main(String[] args) {
        managment s1 = new managment();
        s1.setSize(1900, 900);
        s1.setVisible(true);
    }
}

class close extends WindowAdapter {
    managment k;

    public close(managment p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}

class admin_client extends Frame implements ActionListener {
    Button admin;
    Button patient;
    Button doctors;
    Button nurses;

    public admin_client() {
        admin = new Button("Admin");
        patient = new Button("Patient");
        doctors = new Button("Doctors");
        nurses = new Button("Nurses");
        setLayout(null);
        add(admin);
        add(patient);
        add(doctors);
        add(nurses);

        admin.setBounds(600, 450, 150, 30);
        patient.setBounds(790, 450, 150, 30);
        doctors.setBounds(600, 500, 150, 30);
        nurses.setBounds(790, 500, 150, 30);


        admin.addActionListener(this);
        patient.addActionListener(this);
        doctors.addActionListener(this);
        nurses.addActionListener(this);

        addWindowListener(new close1(this));
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();

        if (str.equals("Admin")) {
            inside_admin_login s1 = new inside_admin_login();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Patient")) {
            inside_patient_login s1=new inside_patient_login();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Doctors")) {
            inside_doctors_login s1=new inside_doctors_login();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Nurses")) {
            inside_nurses_login s1=new inside_nurses_login();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class inside_patient_change extends Frame implements ActionListener{
    String string1="<html><h4>Patient-ID >  </h4></html>";
    String header;
    Label name;
    TextField tname;
    Label oldpass;
    TextField oldpasss;
    Label newpass;
    TextField newpasss;
    Label retypepass;
    TextField retypepasss;
    Label time;
    TextField ttime;
    Button submit;
    int pid;
    Label piddd;
    String string2;

    Label results;

    Button back;


    public inside_patient_change(int x){
        pid = x;
        //System.out.println(pid);
        header = "<html><h1>Change Password</h1></html>";
        string2 = "<html><h3>Patient-ID  </h3></html>";
        piddd = new Label(Integer.toString(pid));
        JLabel pidd = new JLabel(string2);
        JLabel label = new JLabel(header);
        name = new Label("Username > ");
        tname = new TextField(17);
        oldpass = new Label("Old Pass. > ");
        oldpasss = new TextField(17);
        newpass = new Label("New Pass. > ");
        newpasss = new TextField(17);
        retypepass = new Label("Retype > ");
        retypepasss = new TextField(17);
        results = new Label("");

        submit = new Button("Submit");

        back = new Button("Back");

        setLayout(null);

        add(label);
        label.setBounds(660, 161, 300, 50);

        add(pidd);
        pidd.setBounds(670,230,100,15);
        add(piddd);
        piddd.setBounds(770, 230, 100, 15);
        //xx
        add(name);
        add(tname);
        name.setBounds(644, 261, 100, 50);
        tname.setBounds(745, 269, 150, 30);

        add(oldpass);
        add(oldpasss);
        oldpass.setBounds(644, 300, 100, 50);
        oldpasss.setBounds(745, 309, 150, 30);

        add(newpass);
        add(newpasss);
        newpass.setBounds(644, 339, 100, 50);
        newpasss.setBounds(745, 348, 150, 30);

        add(retypepass);
        add(retypepasss);
        retypepass.setBounds(644, 378, 100, 50);
        retypepasss.setBounds(745, 387, 150, 30);

        add(submit);
        submit.setBounds(699, 487, 100, 30);

        add(results);
        results.setBounds(690, 522, 200, 15);

        add(back);
        back.setBounds(690, 550, 100, 30);

        submit.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Submit")){
            int result = login_checking_patient.changePass(pid, newpasss.getText());
            if(result > 0){
                results.setText("Changed Successfully");
            }else{
                results.setText("Looks like something is wrong");
            }
        }else if (str.equals("Back")){
            inside_patient s1 = new inside_patient(pid);
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class inside_patient_forgot extends Frame implements ActionListener{
    int pid;
    String header = "<html><h1>Forgot Password</h1></html>";
    String string1 = "<html><h3>Username  > </h3></html>";
    TextField usernamee;
    String string2 ="<html><h3>Answer  > </h3></html>";
    TextField securityQ;
    String string3 ="<html><h3>SecurityQ  > </h3></html>";
    TextField securityA;
    Button submit;
    Label results;

    Button get;
    public inside_patient_forgot(int x){
       // System.out.println(pid);
        pid = x;
        JLabel label = new JLabel(header);
        label.setBounds(660, 161, 300, 50);

        JLabel username = new JLabel(string1);
        username.setBounds(610, 261, 100, 30);
        usernamee = new TextField(17);
        usernamee.setBounds(710, 267, 150, 23);

        JLabel securityQQ = new JLabel(string2);
        securityQQ.setBounds(610, 292, 100, 30);
        securityQ = new TextField(17);
        securityQ.setBounds(710, 295, 150, 23);

        JLabel securityAA = new JLabel(string3);
        securityAA.setBounds(610, 323, 100, 30);
        securityA = new TextField(17);
        securityA.setBounds(710, 326, 150, 23);

        submit = new Button("Submit");
        submit.setBounds(699, 360, 100, 30);

        get = new Button("Get the Q");
        get.setBounds(812, 360, 150, 30);

        results = new Label("");
        results.setBounds(699, 390, 300, 20);

        setLayout(null);

        add(label);
        add(username);
        add(usernamee);
        add(securityQQ);
        add(securityQ);
        add(securityAA);
        add(securityA);
        add(submit);
        add(get);
        add(results);
        submit.addActionListener(this);
        get.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Get the Q")){
            String result = login_checking_patient.retrieveQuestion(usernamee.getText());
            //System.out.println(result);
            securityA.setText(result);
        }else if(str.equals("Submit")){
            String result = login_checking_patient.forgotCheck(securityQ.getText(),usernamee.getText());
            results.setText(result);
        }
    }
}
class inside_patient_login extends Frame implements ActionListener{
    public int pid;
    String header = "<html><h1>Login/SignUp</h1></html>";
    String string1 = "<html><h3>User-ID  > </h3></html>";
    TextField usernamee;
    String string2 ="<html><h3>Password  > </h3></html>";
    TextField passwordd;
    Button submit;
    Label results;
    String string3 = "<html><h4>Not a user here? </h3></html>";
    Button siup;
    Button forgot;
    Button back;

    public inside_patient_login(){
        JLabel label = new JLabel(header);
        label.setBounds(660, 161, 300, 50);

        JLabel username = new JLabel(string1);
        username.setBounds(610, 261, 100, 30);
        usernamee = new TextField(17);
        usernamee.setBounds(710, 267, 150, 23);

        JLabel password = new JLabel(string2);
        password.setBounds(610, 292, 100, 30);
        passwordd = new TextField(17);
        passwordd.setBounds(710, 295, 150, 23);

        submit = new Button("Login");
        submit.setBounds(699, 333, 100, 30);

        results = new Label("");
        results.setBounds(699, 380, 300, 20);

        JLabel signup = new JLabel(string3);
        signup.setBounds(610,407,100,30);

        siup = new Button("Sign Up");
        siup.setBounds(730,407,100,30);

        forgot = new Button("Forgot Password");
        forgot.setBounds(672, 444, 100, 30);

        back = new Button("Back");
        back.setBounds(674, 484, 100, 30);

        setLayout(null);

        add(label);
        add(username);
        add(usernamee);
        add(password);
        add(passwordd);
        add(submit);
        add(results);
        add(signup);
        add(siup);
        add(forgot);
        add(back);
        submit.addActionListener(this);
        siup.addActionListener(this);
        forgot.addActionListener(this);
        back.addActionListener(this);
        addWindowListener(new close8(this));
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Sign Up")){
            inside_patient_signup s1 = new inside_patient_signup();
            s1.setSize(1900, 900);
            s1.setVisible(true); 

            dispose();
        }else if(str.equals("Login")){
            pid = login_checking_patient.getPatientID(usernamee.getText(), passwordd.getText());
            boolean result = login_checking_patient.loginnCheck(usernamee.getText(), passwordd.getText());
            if (result == true){
                results.setText("LogIn Successfull");
                inside_patient s1 = new inside_patient(pid);
                s1.setSize(1900, 900);
                s1.setVisible(true);

                dispose();
            }else{
                results.setText("OOps! looks like incorrect username/password");
            }
        }else if (str.equals("Forgot Password")){
            inside_patient_forgot s1 = new inside_patient_forgot(pid);
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Back")){
            admin_client s1 = new admin_client();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }

    }
}
class close8 extends WindowAdapter {
    inside_patient_login k;

    public close8(inside_patient_login p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class inside_patient_signup extends Frame implements ActionListener{
    String header = "<html><h1>Sign Up</h1></html>";
    String string1 = "<html><h3>Name  > </h3></html>";
    TextField namee;
    String string2 ="<html><h3>Age  > </h3></html>";
    TextField agee;
    String string3 = "<html><h3>User-ID >  </h3></html>";
    TextField usernamee;
    String string4 = "<html><h3>Password >  </h3></html>";
    TextField passwordd;
    String string5 = "<html><h3>Retype >    </h3></html>";
    TextField retypee;
    String string6 = "<html><h3>SecurityQ >    </h3></html>";
    TextField secsymm;
    String string7 = "<html><h3>Answer >    </h3></html>";
    TextField hintt;
    Label results;
    Button register;
    Button login;

    public inside_patient_signup(){
        JLabel label = new JLabel(header);
        label.setBounds(660, 161, 300, 50);

        JLabel name = new JLabel(string1);
        name.setBounds(610, 261, 100, 30);
        namee = new TextField(17);
        namee.setBounds(710, 267, 150, 23);

        JLabel age = new JLabel(string2);
        age.setBounds(610, 292, 100, 30);
        agee = new TextField(17);
        agee.setBounds(710, 295, 150, 23);

        JLabel username = new JLabel(string3);
        username.setBounds(610, 323, 100, 30);
        usernamee = new TextField(17);
        usernamee.setBounds(710, 323, 150, 23);

        JLabel password = new JLabel(string4);
        password.setBounds(610, 354, 100, 30);
        passwordd = new TextField(17);
        passwordd.setBounds(710, 354, 150, 23);

        JLabel retype = new JLabel(string5);
        retype.setBounds(610, 382, 100, 30);
        retypee = new TextField(17);
        retypee.setBounds(710, 385, 150, 23);

        JLabel secsym = new JLabel(string6);
        secsym.setBounds(610, 410, 100, 30);
        secsymm = new TextField(17);
        secsymm.setBounds(710, 413, 150,23);

        JLabel hint = new JLabel(string7);
        hint.setBounds(610, 438, 100, 30);
        hintt = new TextField(17);
        hintt.setBounds(710, 441, 150,23);

        register = new Button("Register");
        register.setBounds(662, 470, 100, 30);

        results = new Label("");
        results.setBounds(652, 500, 300, 30);

        login = new Button("Back to Login Page");
        login.setBounds(662, 540, 110, 30);


        setLayout(null);

        add(label);
        add(name);
        add(namee);
        add(age);
        add(agee);
        add(username);
        add(usernamee);
        add(password);
        add(passwordd);
        add(retype);
        add(retypee);
        add(secsym);
        add(secsymm);
        add(hint);
        add(hintt);
        add(register);
        add(results);
        add(login);

        register.addActionListener(this);
        login.addActionListener(this);
        addWindowListener(new close9(this));
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Register") && passwordd.getText().equals(retypee.getText())){
            int result = login_checking_patient.registerDetails(namee.getText(), Integer.parseInt(agee.getText()), usernamee.getText(), passwordd.getText(), secsymm.getText(),hintt.getText());
            if (result > 0){
                results.setText("Registered Successfully");
            }else {
                results.setText("Not registered. Try again");
            }
        }else {
            results.setText("Oops! the password doesn't match");
        }
        if (str.equals("Back to Login Page")){
            inside_patient_login s1 = new inside_patient_login();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class close9 extends WindowAdapter {
    inside_patient_signup k;

    public close9(inside_patient_signup p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class inside_admin_login extends Frame implements ActionListener{

    String header = "<html><h1>Login</h1></html>";
    String string1 = "<html><h3>ID  > </h3></html>";
    TextField usernamee;
    String string2 ="<html><h3>Password  > </h3></html>";
    TextField passwordd;
    Button submit;
    Label results;
    Button back;

    public inside_admin_login(){
        JLabel label = new JLabel(header);
        label.setBounds(660, 161, 300, 50);

        JLabel username = new JLabel(string1);
        username.setBounds(610, 261, 100, 30);
        usernamee = new TextField(17);
        usernamee.setBounds(710, 267, 150, 23);

        JLabel password = new JLabel(string2);
        password.setBounds(610, 292, 100, 30);
        passwordd = new TextField(17);
        passwordd.setBounds(710, 295, 150, 23);

        submit = new Button("Submit");
        submit.setBounds(699, 333, 100, 30);

        results = new Label("");
        results.setBounds(699, 380, 300, 30);

        back = new Button("Back");
        back.setBounds(699, 420, 100,30);

        setLayout(null);

        add(label);
        add(username);
        add(usernamee);
        add(password);
        add(passwordd);
        add(submit);
        add(results);
        add(back);
        submit.addActionListener(this);
        back.addActionListener(this);
        addWindowListener(new close7(this));
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Submit")){
            boolean result = login_checking_admin.loginCheck(usernamee.getText(), passwordd.getText());

            if (result == true){
                results.setText("Registered Official");
                inside_admin s1 = new inside_admin();
                s1.setSize(1900, 900);
                s1.setVisible(true);

                dispose();
            }else {
                results.setText("Sorry! but you seem to have entered wrong ID/password");
            }
        }else{
            admin_client s1 = new admin_client();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
    }
} 
class close7 extends WindowAdapter {
    inside_admin_login k;

    public close7(inside_admin_login p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class close1 extends WindowAdapter {
    admin_client k;

    public close1(admin_client p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}

class inside_admin extends Frame implements ActionListener {
    Button office;
    Button back;
    public inside_admin() {
        office = new Button("Office");
        back = new Button("Back");
        setLayout(null);

        add(office);
        office.setBounds(630, 400, 150, 50);

        add(back);
        back.setBounds(650, 480, 100, 30);

        office.addActionListener(this);
        back.addActionListener(this);
        addWindowListener(new close2(this));
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();

        if (str.equals("Office")) {
            inside_office s1=new inside_office();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else {
            admin_client s1 = new admin_client();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();

        }
    }
}
class close2 extends WindowAdapter {
    inside_admin k;

    public close2(inside_admin p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class set_appointments extends Frame implements ActionListener{
    String string1="<html><h4>Patient-ID >  </h4></html>";
    String header;
    Label name;
    TextField tname;
    Label DOB;
    TextField tDOB;
    Label address;
    TextField taddress;
    Label number;
    TextField tnumber;
    Label appdate;
    TextField tappdate;
    Label time;
    TextField ttime;
    Button submit;
    int pid;
    Label piddd;
    String string2;

    Label results;

    Button back;


    public set_appointments(int x){
        pid = x;
        //System.out.println(pid);
        header = "<html><h1>Set Appointment</h1></html>";
        string2 = "<html><h3>Patient-ID  </h3></html>";
        piddd = new Label(Integer.toString(pid));
        JLabel pidd = new JLabel(string2);
        JLabel label = new JLabel(header);
        name = new Label("Enter name > ");
        tname = new TextField(17);
        DOB = new Label("DOB > ");
        tDOB = new TextField(17);
        address = new Label("Address > ");
        taddress = new TextField(17);
        appdate = new Label("App. date > ");
        tappdate = new TextField(17);
        time = new Label("Time > ");
        ttime = new TextField(17);
        results = new Label("");

        submit = new Button("Submit");
        back = new Button("Back");

        setLayout(null);

        add(label);
        label.setBounds(660, 161, 300, 50);

        add(pidd);
        pidd.setBounds(670,230,100,15);
        add(piddd);
        piddd.setBounds(770, 230, 100, 15);

        add(name);
        add(tname);
        name.setBounds(644, 261, 100, 50);
        tname.setBounds(745, 269, 150, 30);

        add(DOB);
        add(tDOB);
        DOB.setBounds(644, 300, 100, 50);
        tDOB.setBounds(745, 309, 150, 30);

        add(address);
        add(taddress);
        address.setBounds(644, 339, 100, 50);
        taddress.setBounds(745, 348, 150, 30);

        add(appdate);
        add(tappdate);
        appdate.setBounds(644, 378, 100, 50);
        tappdate.setBounds(745, 387, 150, 30);

        add(time);
        add(ttime);
        time.setBounds(644, 417, 100, 50);
        ttime.setBounds(745, 426, 150, 30);

        add(submit);
        submit.setBounds(699, 487, 100, 30);

        add(results);
        results.setBounds(690, 522, 200, 15);

        add(back);
        back.setBounds(699, 550, 100, 30);

        submit.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Submit")){
            int result = login_checking_patient.appRegister(pid, tname.getText(),tDOB.getText(), taddress.getText(),tappdate.getText(),ttime.getText()); 

            if (result > 0){
                results.setText("Submitted Successfully");
                inside_patient s1=new inside_patient(pid);
                s1.setSize(1900, 900);
                s1.setVisible(true);

                dispose();
            }else {
                results.setText("looks like something wrong!");
            }
        }else if (str.equals("Back")){
            inside_patient s1 = new inside_patient(pid);
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }


    }
}
class inside_patient extends Frame implements ActionListener {
    Button set_appointment;
    Button change_pass;
    Button back;
    int pid;

    public inside_patient(int x) {
        pid = x;
        set_appointment = new Button("Set Appointment");
        change_pass = new Button("Change Password");
        back = new Button("Back");
        setLayout(null);

        add(set_appointment);

        set_appointment.setBounds(700, 450, 150, 30);

        add(change_pass);
        change_pass.setBounds(700, 500, 150, 50);
        
        add(back);
        back.setBounds(700, 560, 100, 30);


        set_appointment.addActionListener(this);
        change_pass.addActionListener(this);
        back.addActionListener(this);

        addWindowListener(new close3(this));
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("Set Appointment")){
            set_appointments s1 = new set_appointments(pid);
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
        else if(str.equals("Change Password")){
            inside_patient_change s1 = new inside_patient_change(pid);
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Back")){
            admin_client s1 = new admin_client();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class close3 extends WindowAdapter {
    inside_patient k;

    public close3(inside_patient p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class inside_office_doctors extends Frame implements ActionListener{
    Button listDoctors;
    Button back;
    public TextArea values;

    public inside_office_doctors() {
        listDoctors = new Button("List Doctors");
        //values = new TextArea(1900, 500);
        back = new Button("Back");
        setLayout(null);

        add(listDoctors);
        listDoctors.setBounds(630, 40, 150, 50);
        add(back);
        back.setBounds(630, 640, 100, 30);
       // add(values);
       // values.setBounds(630, 100, 700, 500);

        listDoctors.addActionListener(this);
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("List Doctors")){
            String header[]={"DOCTOR_ID","NAME","AGE","GENDER","USERNAME","SALARY"};
            int count = login_checking_doctor_and_nurse.getRowsDoctors();
            Object [][]data = login_checking_doctor_and_nurse.getDoctors(count);

            JTable table = new JTable(data, header);
            JScrollPane scrollPane = new JScrollPane(table);
            setLayout(null);  
            setLayout(new BorderLayout());
            add(scrollPane, BorderLayout.CENTER);
            listDoctors.setVisible(false);
        }else if (str.equals("Back")){
            inside_office s1 = new inside_office();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class inside_office_nurses extends Frame implements ActionListener{
    Button listDoctors;
    Button back;
    public TextArea values;

    public inside_office_nurses() {
        listDoctors = new Button("List Nurses");
       // values = new TextArea(1900, 500);
        back = new Button("Back");
        setLayout(null);

        add(listDoctors);
        listDoctors.setBounds(630, 40, 150, 50);
        add(back);
        back.setBounds(630, 640, 100, 30);
       // add(values);
       // values.setBounds(630, 100, 700, 500);

        listDoctors.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("List Nurses")){
            String header[]={"NURSE_ID","NAME","AGE","GENDER","USERNAME","SALARY"};
            int count = login_checking_doctor_and_nurse.getRowsNurses();
            Object [][]data = login_checking_doctor_and_nurse.getNurses(count);

            JTable table = new JTable(data, header);
            JScrollPane scrollPane = new JScrollPane(table);
            setLayout(null);  
            setLayout(new BorderLayout());
            add(scrollPane, BorderLayout.CENTER);
            listDoctors.setVisible(false);
        }else if (str.equals("Back")){
            inside_office s1 = new inside_office();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class inside_office_salary extends Frame implements ActionListener{
    Button bt;
    Button btt;
    Button back;
    public inside_office_salary(){
        bt = new Button("Doctor's Salary");
        btt = new Button("Nurse's Salary");
        back = new Button("Back");
        setLayout(null);
        add(bt);
        add(btt);
        add(back);
        bt.setBounds(660, 270, 150, 50);
        btt.setBounds(660, 340, 150, 50);
        back.setBounds(670, 410, 100, 30);

        bt.addActionListener(this);
        btt.addActionListener(this);

    }   
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Doctor's Salary")){
            inside_office_doctors s1 = new inside_office_doctors();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Nurse's Salary")){
            inside_office_nurses s1 = new inside_office_nurses();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Back")){
            inside_office s1 = new inside_office();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class changeStatus extends Frame implements ActionListener{
    String string = "<html><h3>Enter patient ID > </h3></html>";
    TextField check;
    Button bt;

    public changeStatus(){
        JLabel status = new JLabel(string);
        setLayout(null);
        add(status);
        status.setBounds(150,40, 150, 20);
        check = new TextField(17);
        add(check);
        check.setBounds(305, 40, 150, 30);
        bt = new Button("Update");
        add(bt);
        bt.setBounds(165, 80, 100, 30);

        bt.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        int result = login_checking_doctor_and_nurse.status(Integer.parseInt(check.getText()));


        if (result > 0){
            System.out.println("done");
        }else{
            System.out.println("not done");
        }

    }
}
class inside_office extends Frame implements ActionListener {
    Button listDoctors;
    Button listnurses;
    Button salary;
    Button changeStatus;
    Button back;

    public inside_office() {
        salary = new Button("Salary");
        listDoctors = new Button("List Doctors");
        listnurses = new Button("List Nurses");
        back = new Button("Back");
        changeStatus = new Button("Change Status");
        setLayout(null);

        add(salary);
        add(listDoctors);
        add(listnurses);
        add(changeStatus);
        add(back);
        salary.setBounds(600, 450, 150, 30);
        listDoctors.setBounds(790, 450, 150, 30);
        listnurses.setBounds(697, 500, 150, 30);
        changeStatus.setBounds(699, 550, 200, 30);
        back.setBounds(699, 600, 100, 30);

        listDoctors.addActionListener(this);
        listnurses.addActionListener(this);
        salary.addActionListener(this);
        back.addActionListener(this);
        changeStatus.addActionListener(this);

        addWindowListener(new close4(this));
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("List Doctors")){
            inside_office_doctors s1 = new inside_office_doctors();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
        else if (str.equals("List Nurses")){
            inside_office_nurses s1 = new inside_office_nurses();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
        else if (str.equals("Salary")){
            inside_office_salary s1 = new inside_office_salary();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Back")){
            inside_admin s1 = new inside_admin();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }else if (str.equals("Change Status")){
            changeStatus s1 =new changeStatus();
            s1.setSize(700,200);
            s1.setVisible(true);
        }
    }
}
class close4 extends WindowAdapter {
    inside_office k;
    public close4(inside_office p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class inside_doctors_login extends Frame implements ActionListener{
    String header = "<html><h1>Login</h1></html>";
    String string1 = "<html><h3>ID  > </h3></html>";
    TextField usernamee;
    String string2 ="<html><h3>Password  > </h3></html>";
    TextField passwordd;
    Button submit;
    Label results;
    Button back;

    public inside_doctors_login(){
        JLabel label = new JLabel(header);
        label.setBounds(660, 161, 300, 50);

        JLabel username = new JLabel(string1);
        username.setBounds(610, 261, 100, 30);
        usernamee = new TextField(17);
        usernamee.setBounds(710, 267, 150, 23);

        JLabel password = new JLabel(string2);
        password.setBounds(610, 292, 100, 30);
        passwordd = new TextField(17);
        passwordd.setBounds(710, 295, 150, 23);

        submit = new Button("Submit");
        submit.setBounds(699, 333, 100, 30);

        results = new Label("");
        results.setBounds(699, 380, 300, 30);

        back = new Button("Back");
        back.setBounds(670, 420, 100,30);

        setLayout(null);

        add(label);
        add(username);
        add(usernamee);
        add(password);
        add(passwordd);
        add(submit);
        add(results);
        add(back);
        submit.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("Submit")){
            boolean result = login_checking_doctor_and_nurse.loginCheckDoctor(usernamee.getText(), passwordd.getText());

            if (result == true){
                results.setText("Registered Official");
                inside_doctors s1 = new inside_doctors();
                s1.setSize(1900, 900);
                s1.setVisible(true);

                dispose();
            }else {
                results.setText("Sorry! but you seem to have entered wrong ID/password");
            }
        }else if (str.equals("Back")){
            admin_client s1 =new admin_client();
            s1.setSize(1900, 900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class inside_doctors extends Frame implements ActionListener {
    Button listDoctors;
    Button back;
    public TextArea values;

    public inside_doctors() {
        listDoctors = new Button("List Appointments");
        values = new TextArea(1900, 500);

        back = new Button("Back");
        setLayout(null);

        add(listDoctors);
        listDoctors.setBounds(630, 40, 150, 50);
       // add(values);
       // values.setBounds(630, 100, 700, 500);
       add(back);
       back.setBounds(630, 640, 100,30);

        listDoctors.addActionListener(this);
        back.addActionListener(this);

        addWindowListener(new close5(this));
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        
        if (str.equals("List Appointments")){
            String header[]={"ID","NAME","DOB","ADDRESS","APP_DATE","APP_TIME","ASSIGNED_NURSE","STATUS"};
            int count = login_checking_doctor_and_nurse.getRows();
            Object [][]data = login_checking_doctor_and_nurse.listappointment1(count);

            JTable table = new JTable(data, header);
            JScrollPane scrollPane = new JScrollPane(table);
            setLayout(null);  
            setLayout(new BorderLayout());
            add(scrollPane, BorderLayout.CENTER);
            listDoctors.setVisible(false);
        }else if (str.equals("Back")){
            admin_client s1 = new admin_client();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}

class close5 extends WindowAdapter {
    inside_doctors k;

    public close5(inside_doctors p) {
        k = p;
    }
    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}
class inside_nurses_login extends Frame implements ActionListener{
    String header = "<html><h1>Login</h1></html>";
    String string1 = "<html><h3>ID  > </h3></html>";
    TextField usernamee;
    String string2 ="<html><h3>Password  > </h3></html>";
    TextField passwordd;
    Button submit;
    Label results;
    Button back;

    public inside_nurses_login(){
        JLabel label = new JLabel(header);
        label.setBounds(660, 161, 300, 50);

        JLabel username = new JLabel(string1);
        username.setBounds(610, 261, 100, 30);
        usernamee = new TextField(17);
        usernamee.setBounds(710, 267, 150, 23);

        JLabel password = new JLabel(string2);
        password.setBounds(610, 292, 100, 30);
        passwordd = new TextField(17);
        passwordd.setBounds(710, 295, 150, 23);

        submit = new Button("Submit");
        submit.setBounds(699, 333, 100, 30);

        results = new Label("");
        results.setBounds(699, 380, 300, 30);

        back = new Button("Back");
        back.setBounds(699, 430, 100,30);

        setLayout(null);

        add(label);
        add(username);
        add(usernamee);
        add(password);
        add(passwordd);
        add(submit);
        add(results);
        add(back);
        submit.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();

        if (str.equals("Submit")){
            boolean result = login_checking_doctor_and_nurse.loginCheckNurse(usernamee.getText(), passwordd.getText());

            if (result == true){
                results.setText("Registered Official");
                inside_nurses s1 = new inside_nurses(usernamee.getText(), passwordd.getText());
                s1.setSize(1900, 900);
                s1.setVisible(true);

                dispose();
            }else {
                results.setText("Sorry! but you seem to have entered wrong ID/password");
            }
        }else if (str.equals("Back")){
            admin_client s1 = new admin_client();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}
class inside_nurses extends Frame implements ActionListener {
    Button listNurses;  
    String string1 = "<html><h3>Enter the patient ID  > </h3></html>";
    Button enter1;
    TextField enter2;
    String username, password;
    Label done;
    Button back;

    public inside_nurses(String x,String y) {
        username = x;
        password = y;
        listNurses = new Button("List Doctors's Appointments");
        enter1 = new Button("Get Assignment");
        setLayout(null);

        add(listNurses);
        listNurses.setBounds(630, 40, 150, 50);
        JLabel enter = new JLabel(string1);
        add(enter);
        enter.setBounds(630, 360, 150, 20);
        add(enter1);
        enter1.setBounds(707, 400, 150, 23);
        enter2 = new TextField(3);
        add(enter2);
        enter2.setBounds(780, 360, 150, 23);

        done = new Label("");
        add(done);
        done.setBounds(700, 430, 300, 23);

        back = new Button("Back");
        back.setBounds(708, 470, 100,30);


        listNurses.addActionListener(this);
        enter1.addActionListener(this);
        back.addActionListener(this);

        addWindowListener(new close6(this));
    }

    public void actionPerformed(ActionEvent ae) {
        String header[]={"ID","NAME","DOB","ADDRESS","APP_DATE","APP_TIME"};
        int count = login_checking_doctor_and_nurse.getRows();
        Object [][]data = login_checking_doctor_and_nurse.listappointment1(count);
        String str = ae.getActionCommand();
        if (str.equals("List Doctors's Appointments"))
        {
            JTable table = new JTable(data, header);
            JScrollPane scrollPane = new JScrollPane(table);        
            setLayout(null);  
            add(scrollPane);
            scrollPane.setBounds(230, 40, 900, 300);
            listNurses.setVisible(false);
        }
        else if (str.equals("Get Assignment")){
            String name = login_checking_doctor_and_nurse.getNurseName(username, password);
           // System.out.println("name is "+name);
           // System.out.println(username);
           // System.out.println(password);
            int result = login_checking_doctor_and_nurse.getAssignment(Integer.parseInt(enter2.getText()),name);
           // System.out.println("ENTER  2 "+enter2.getText());

            if (result > 0){
                done.setText("You successfully got the assignment");
            }
            else{
                done.setText("Looks like the slot is already taken");
            }
        }else if (str.equals("Back")){
            admin_client s1 = new admin_client();
            s1.setSize(1900,900);
            s1.setVisible(true);

            dispose();
        }
    }
}

class close6 extends WindowAdapter {
    inside_nurses k;
    public close6(inside_nurses p) {
        k = p;
    }

    public void windowClosing(WindowEvent we) {
        k.dispose();
    }
}