

package controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user;
import dto.userdeo;

@WebServlet("/Update")
public class Update extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 user user=new user();
	 user.setAddress(req.getParameter("add"));
	 user.setEmail(req.getParameter("email"));
	 user.setGender(req.getParameter("d"));
	 user.setMobile(Long.parseLong(req.getParameter("mobile")));
	 user.setName(req.getParameter("name"));
	 user.setPassword(req.getParameter("pass"));
	 
	 
	 userdeo userdeo=new userdeo();
	 userdeo.update(user);
	 
	 res.getWriter().print("<h1>Data updated successfully</h1>");
	 req.setAttribute("list",userdeo.fetchAll());
	 req.getRequestDispatcher("Home.jsp").include(req, res);
	 
	 
}
}
