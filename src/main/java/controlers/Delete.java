package controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user;
import dto.userdeo;

@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		userdeo deo=new userdeo();
		user user=deo.find(email);
		deo.delete(user);
		
		req.setAttribute("list",deo.fetchAll());
		resp.getWriter().print("<h1>Date deleted successfully</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, resp);
		
	}

}
