package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Fees extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name_adm");
        String contact = request.getParameter("number_adm");
        String uid = request.getParameter("uid_adm");
        String course = request.getParameter("course");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String Fees = request.getParameter("Fees_adm");
        String btn = request.getParameter("submit");
        
        
        if(btn.equals("Submit")){
            try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/College_Management", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into fees values(?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, contact);
            ps.setString(3, uid);
            ps.setString(4, course);
            ps.setString(5, email);
            ps.setString(6, address);
            ps.setString(7, Fees);
            ps.executeUpdate();
        } catch (Exception e) {
            out.println(e);
            
            
        }
        }

    }
}
