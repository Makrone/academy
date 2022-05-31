package by.it_academy.jd2.Mk_JD2_90_22.aviasales.service;

import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.AirportDAO;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IAirportDAO;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Airport;

public class AirportService {

	private static final AirportService instance = new AirportService();

	private IAirportDAO airportDAO;

	private AirportService() {
		super();
		airportDAO = new AirportDAO();

	}

	public List<Airport> getAll() {
		return airportDAO.getAll();
	}

	public static AirportService getInstance() {
		return instance;
	}

}