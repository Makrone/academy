package by.it_academy.jd2.Mk_JD2_90_22.aviasales.test;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.AirportDAO;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Airport;

public class AirportTest {

	public static void main(String[] args) {
		AirportDAO air = new AirportDAO();
		Airport ar = air.get("ASK");
		System.out.println(ar);
	}

}
