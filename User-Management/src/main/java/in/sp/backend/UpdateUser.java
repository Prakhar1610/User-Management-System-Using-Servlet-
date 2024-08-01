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

@WebServlet("/update")
public class UpdateUser extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		String myid = req.getParameter("id2");
		String myname = req.getParameter("name2");
		String myemail = req.getParameter("email2");
		String mycountry = req.getParameter("country2");

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb" , "root" , "mysql@123");
			
			PreparedStatement ps = con.prepareStatement("update users set Name=? , Email=? , Country=? where Id=?");
           
            ps.setString(1 , myname);
            ps.setString(2 , myemail);
            ps.setString(3 , mycountry);
            ps.setString(4 , myid);
            
			int rs = ps.executeUpdate();

			RequestDispatcher rd;
			if(rs > 0)
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'>User updated</h3>");
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
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception Occured : "+e.getMessage()+"</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/user-list.jsp");
			rd.include(req, resp);
		}
	}
}
