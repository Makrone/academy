package by.it_academy.jd2.Mk_JD2_90_22.aviasales.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.service.AirportService;

@WebServlet(name = "AirportIndexServlet", urlPatterns = "/servlets/airportIndex")
public class AirportIndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final AirportService airportService;

	public AirportIndexServlet() {
		super();
		this.airportService = AirportService.getInstance();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		req.setAttribute("airports", airportService.getAll());
		req.getRequestDispatcher("/jsp/airportMain.jsp").forward(req, resp);
	}

}
