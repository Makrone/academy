package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Airport;

public class AirportDAO extends AbstractDAO<String, Airport> implements IAirportDAO{

	private static final String GET_ALL_AIRPORTS = "SELECT * FROM bookings.airports_data";
	private static final String SELECT_AIRPORT_BY_ID = "SELECT * FROM bookings.airports_data WHERE code = ?";
	private static final String DELETE_AIRPORT_BY_ID = "DELETE FROM bookings.airports_data WHERE code = ?";

	@Override
	public List<Airport> getAll() {
		List<Airport> airports = new ArrayList<>();
		Connection connection = getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_AIRPORTS);) {
			while (resultSet.next()) {
				airports.add(populateAirport(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			releaseConnection(connection);
		}

		return airports;
	}

	@Override
	public Airport get(String code) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_AIRPORT_BY_ID)) {
			preparedStatement.setString(1, code);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateAirport(resultSet);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public Boolean delete(String id) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_AIRPORT_BY_ID)) {
			preparedStatement.setString(1, id);
			return preparedStatement.executeUpdate() > 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			releaseConnection(c);
		}

	}

	private Airport populateAirport(ResultSet resultSet) throws SQLException {
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

