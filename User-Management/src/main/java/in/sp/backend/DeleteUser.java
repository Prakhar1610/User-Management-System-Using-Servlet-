package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		String myid = req.getParameter("id1");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb" , "root" , "mysql@123");
			
			PreparedStatement ps = con.prepareStatement("delete from users where Id=?");
            ps.setString(1 , myid);
            
			int rs = ps.executeUpdate();
			
			RequestDispatcher rd;
			if(rs > 0)
			{
				rd = req.getRequestDispatcher("/user-list.jsp");
				rd.include(req, resp);
			}
			else
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>User of this id doesn't exist in the database</h3>");
				
				rd = req.getRequestDispatcher("/user-list.jsp");
				rd.include(req, resp);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
