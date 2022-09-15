
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class teacher_report_ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name=request.getParameter("Teacher_Rep");
        String contact = request.getParameter("number_rep");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("pass");
        String confirm_pass = request.getParameter("conf_pass");
        String btn = request.getParameter("submit");
        
        if(btn.equals("Submit"))
        {
            if(password.equals(confirm_pass)){
                try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/College_Management", "root", "root");
                PreparedStatement ps = con.prepareStatement("insert into teacher_report values (?,?,?,?,?)");
                ps.setString(1,name);
                ps.setString(2,contact);
                ps.setString(3,email);
                ps.setString(4,address);
                ps.setString(5,password);
                int row = ps.executeUpdate();
                out.println(row+"Registration Successfull");
            }
            catch(Exception e){out.println(e);}
            }
            else{
                out.println("Registration UnSuccessfull");
            }
        }
        
    }}