package by.it_academy.jd2.Mk_JD2_90_22.aviasales.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Airport;

public class TestConnectionAirport {
	private static String GET_ALL_AIRPORTS = "SELECT * FROM bookings.airports_data";

	public static void main(String[] args) {

		ConnectionPool.getInstance().getConnection();
		List<Airport> airports = new ArrayList<>();

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_AIRPORTS);) {
			while (resultSet.next()) {
				airports.add(populateAirport(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(airports);
	}

	private static Airport populateAirport(ResultSet resultSet) throws SQLException {
		Airport airport = new Airport();
		airport.setCode(resultSet.getString(Fields.AIRPORT_CODE));
		airport.setName(resultSet.getString(Fields.AIRPORT_NAME));
		airport.setCity(resultSet.getString(Fields.CITY));
		airport.setCoordinates(resultSet.getString(Fields.COORDINATES));
		airport.setTimezone(resultSet.getString(Fields.TIMEZONE));
		return airport;
	}

	class Fields {
		private static final String AIRPORT_CODE = "airport_code";
		private static final String AIRPORT_NAME = "airport_name";
		private static final String CITY = "city";
		private static final String COORDINATES = "coordinates";
		private static final String TIMEZONE = "timezone";

	}
}
