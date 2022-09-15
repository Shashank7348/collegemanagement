
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class check extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uid_check = request.getParameter("uid_check");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/College_Management", "root", "root");
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select * from fees where uid = '" + uid_check + "'");
            while (res.next()) {
                if (uid_check.equals(res.getString(3)));
                {
                    out.println("\n"
                            + "        <table>\n"
                            + "            <th>UID</th>\n"
                            + "            <th>Fees</th>\n"
                            + "            \n"
                            + "            <tr>\n"
                            + "                <td>"+res.getString(3)+"</td>\n"
                            + "                <td>"+res.getString(7)+"</td>\n"
                            + "            </tr>\n"
                            + "        </table>");
                }
            }
        } catch (Exception e) {
            out.println(e);

        }
    }

}
