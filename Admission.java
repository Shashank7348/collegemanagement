
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admission extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name=request.getParameter("name_adm");
        String contact = request.getParameter("number_adm");
        String uid = request.getParameter("uid_adm");
        String course = request.getParameter("course");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("pass");
        String confirm_pass = request.getParameter("conf_pass");
        String btn = request.getParameter("submit");
        
        if(btn.equals("Admission"))
        {
            if(password.equals(confirm_pass)){
                try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/College_Management", "root", "root");
                PreparedStatement ps = con.prepareStatement("insert into stud_admission values (?,?,?,?,?,?,?)");
                ps.setString(1,name);
                ps.setString(2,contact);
                ps.setString(3,uid);
                ps.setString(4,email);
                ps.setString(5,address);
                ps.setString(6,password);
                ps.setString(7, course);
                int row = ps.executeUpdate();
                out.println(row+" Admission Successfull"+"<br><br>");
                out.println("Name: "+name+"<br>");
                out.println("Contact: "+contact+"<br>");
                out.println("UID: "+ uid+"<br>");
                out.println("Email: "+email+"<br>");
                out.println("Address: "+address+"<br>");
                out.println("PAssword: "+password+"<br>");
            }
            catch(Exception e){out.println(e);}
            }
            else{
                out.println("Admission UnSuccessfull");
            }
        }
        
    }

}
