
package controlers;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dto.user;
import dto.userdeo;



public class Signup extends GenericServlet
{
	
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 String name=req.getParameter("name");    
		 long mobile=Long.parseLong(req.getParameter("mobile"));
		 String email=req.getParameter("email");
		 String password=req.getParameter("pass");
		 String gender=req.getParameter("d");
		 String address=req.getParameter("add");
		 
		 
		 String cname= getServletConfig().getInitParameter("cname");
		 String cbranch= getServletConfig().getInitParameter("cbranch");
		 
		 
		 
//		 res.getWriter().print("<h1>Name:"+name+"</h1><br>");
//		 res.getWriter().print("<h1>Mobile:"+mobile+"</h1><br>");
//		 res.getWriter().print("<h1>Email:"+email+"</h1><br>");
//		 res.getWriter().print("<h1>Password:"+password+"</h1><br>");
//		 res.getWriter().print("<h1>Gender:"+gender +"</h1><br>");
//		 res.getWriter().print("<h1>Address:"+address+"</h1><br>");
		 
		 user user=new user();
		 user.setAddress(req.getParameter("add"));
		 user.setEmail(req.getParameter("email"));
		 user.setGender(req.getParameter("d"));
		 user.setMobile(Long.parseLong(req.getParameter("mobile")));
		 user.setName(req.getParameter("name"));
		 user.setPassword(req.getParameter("pass"));
		 
		 userdeo userdeo=new userdeo();
		 userdeo.save(user);
		 
		 res.getWriter().print("<h1>Account created Sucessfully in "+cname+" "+cbranch+"</h1>");
		req.getRequestDispatcher("Login.html").include(req, res);
		 
		 
	}

}
