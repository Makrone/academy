package by.it_academy.jd2.Mk_JD2_90_22.aviasales.service;

import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.FlightDAO;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IFlightDAO;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Flight;

public class FlightService {

	private static final FlightService instance = new FlightService();

	private IFlightDAO flightDAO;

	private FlightService() {
		super();
		flightDAO = new FlightDAO();

	}

	public List<Flight> getAll() {
		return flightDAO.getAll();
	}

	public static FlightService getInstance() {
		return instance;
	}
}
