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

@WebServlet("/form")
public class InsertUser extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		String myid = req.getParameter("id1");
		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email1");
		String mycountry = req.getParameter("country1");
		
		if(myid == "")
		{
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Kindly enter the User ID</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
			rd.include(req, resp);
		}
		
		else if(myname == "")
		{
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Kindly enter the User name</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
			rd.include(req, resp);
		}
		
		else if(myemail == "")
		{
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Kindly enter the User email</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
			rd.include(req, resp);
		}
		
		else if(mycountry == "")
		{
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Kindly enter the User country</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
			rd.include(req, resp);
		}
		
		else
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb" , "root" , "mysql@123");
				
				PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)");
				ps.setString(1 , myid);
				ps.setString(2 , myname);
				ps.setString(3 , myemail);
				ps.setString(4 , mycountry);
				
				//This for checking if the user of give id already exist or not
				//Start
				PreparedStatement ps2 = con.prepareStatement("select Id,Name,Email,Country from users where id=?");
				ps2.setString(1 , myid);
				
				ResultSet count2 = ps2.executeQuery();
				
				if(count2.next() == false)
				{
					//If condition is satisfied then it will add the user
					int count = ps.executeUpdate();
					
					if(count > 0)
					{
						resp.setContentType("text/html");
						out.print("<h3 style='color:green'>User Registered Successfully</h3>");
						
						RequestDispatcher rd = req.getRequestDispatcher("/user-list.jsp");
						rd.include(req, resp);
					}
					else
					{
						resp.setContentType("text/html");
						out.print("<h3 style='color:red'>User not added due to some error . Try again</h3>");
						
						RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
						rd.include(req, resp);
					}
				}
				else
				{
					resp.setContentType("text/html");
					out.print("<h3 style='color:red'>User of this id already exist in the database</h3>");
					
					RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
					rd.include(req, resp);
				}
				//End
				
			}
			catch (Exception e) 
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Exception Occured : "+e.getMessage()+"</h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/user-form.jsp");
				rd.include(req, resp);
			}
		}
	}
}
