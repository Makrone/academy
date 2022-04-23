package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Roles;
import domain.User;
import service.UserService;

@WebServlet(name = "LoginServlet", urlPatterns = "/controller/signIn")
public class SignInServlet extends HttpServlet {
	private UserService userService;

	private SignInServlet() {
		super();
		this.userService = new UserService();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");

		req.getRequestDispatcher("/jsp/signIn.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		try {
			Boolean isOkay = userService.checkPassword(req.getParameter("username"), req.getParameter("password"));
			if (isOkay) {
				User user = userService.getByUsername(req.getAttribute("username").toString());
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				if (user.getRole() != null) {
					if (user.getRole() == Roles.ADMIN) {
						resp.sendRedirect(req.getContextPath() + "/controller/adminpage");
					} else if (user.getRole() == Roles.CLIENT) {
						resp.sendRedirect(req.getContextPath() + "/controller/clientpage");
					}

				}
			}
		} catch (Exception e) {
			req.setAttribute("errorMessage", e.getMessage());
			req.getRequestDispatcher("/jsp/signIn.jsp").forward(req, resp);
		}

	}

}
