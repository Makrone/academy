package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Roles;
import domain.User;
import service.UserService;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/controller/registration")
public class RegistrationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public RegistrationServlet() {
		super();
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");

		User user = new User();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		user.setFirstName(req.getParameter("firstName"));
		user.setLastName(req.getParameter("lastName"));
		user.setMiddleName(req.getParameter("middleName"));
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setCreated(new Timestamp(new Date().getTime()));
		user.setRole(Roles.valueOf(req.getParameter("role")));
		try {
			Date dt = format.parse(req.getParameter("dateOfBirth"));
			user.setDateOfBirth(new Timestamp(dt.getTime()));
		} catch (Exception e) {
			System.out.println("Error date format");
		}
		userService.create(user);
		resp.sendRedirect(req.getContextPath() + "/controller/signIn");
	}
}
