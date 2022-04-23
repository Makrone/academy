package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet(name = "WelcomeServlet", urlPatterns = "/controller/welcome")
	public class WelcomeServlet extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=utf-8");
			
			req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
		}

}
