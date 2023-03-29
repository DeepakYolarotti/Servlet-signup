package controlers;

import java.io.IOException;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import dto.user;
import dto.userdeo;

public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 String cname= getServletConfig().getInitParameter("cname");
		 String cbranch= getServletContext().getInitParameter("cbranch");
		
		 
		 userdeo deo=new userdeo();
		 List<user> list=deo.find();
		
		String email=req.getParameter("email");
		String Password=req.getParameter("password"); 
		System.out.println(email);
		System.out.println(Password);
		userdeo userdeo=new userdeo();
		user user=userdeo.find(email);
		if(user==null){
			resp.getWriter().print("<h1>Invalid email</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else 
		{
			if(user.getPassword().equals(Password)){
//				resp.sendRedirect("http://www.youtube.com");
//				 resp.getWriter().print("<h1>Account created Sucessfully in "+ cname +" "+cbranch+"</h1>");
//				resp.getWriter().print("<h1>Login success</h1>");
//				resp.getWriter().print("<table border= '1' >");
//				resp.getWriter().print("<tr>");
//				resp.getWriter().print("<th>Name</th>");
//				resp.getWriter().print("<th>Phone no</th>");
//				resp.getWriter().print("<th>E-mail</th>");
//				resp.getWriter().print("<th>Mobile</th>");
//				resp.getWriter().print("<th>Gender</th>");
//				resp.getWriter().print("<th>Address</th>");
//				resp.getWriter().print("</tr>");
//				resp.getWriter().print("</table>");
				
				resp.getWriter().print("<h1>login successfully</h1>");
				req.setAttribute("list", list);
				req.getRequestDispatcher("Home.jsp").include(req,resp);
				
				
				
//				for(user user2:list )
//				{
//					resp.getWriter().print("<tr>");
//					resp.getWriter().print("<th>"+user2.getName()+"</th>");
//					resp.getWriter().print("<th>"+user2.getPassword()+"</th>");
//					resp.getWriter().print("<th>"+user2.getEmail()+"</th>");
//					resp.getWriter().print("<th>"+user2.getMobile()+"</th>");
//					resp.getWriter().print("<th>"+user2.getGender()+"</th>");
//					resp.getWriter().print("<th>"+user2.getAddress()+"</th>");
//					resp.getWriter().print("</tr>");
//					
//				}
				

			}
			else
			{
				resp.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		
		}
		
	}
}
