package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Flight;


public class FlightDAO extends AbstractDAO<Long, Flight> implements IFlightDAO{
	private static final String GET_ALL_FLIGTS = "SELECT * FROM bookings.flights";
	private static final String SELECT_FLIGTS_BY_ID = "SELECT * FROM bookings.flights WHERE ID = ?";
	private static final String DELETE_FLIGHTS_BY_ID = "DELETE FROM bookings.flights WHERE code = ?";

	@Override
	public List<Flight> getAll() {
		List<Flight> flights = new ArrayList<>();
		Connection connection = getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_FLIGTS);) {
			while (resultSet.next()) {
				flights.add(populateFlight(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			releaseConnection(connection);
		}

		return flights;
	}

	@Override
	public Flight get(Long id) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_FLIGTS_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateFlight(resultSet);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public Boolean delete(Long id) {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_FLIGHTS_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			releaseConnection(c);
		}

		
	}

	private Flight populateFlight(ResultSet resultSet) throws SQLException {
		Flight flight = new Flight();
		flight.setFlightId(resultSet.getLong(Fields.FLIGNT_ID));
		flight.setFlightNo(resultSet.getString(Fields.FLIGHT_NUMBER));
		flight.setScheduledDeparture(resultSet.getTimestamp(Fields.SCHEDULTED_DEPARTURE));
		flight.setScheduledDepartureLocal(resultSet.getTimestamp(Fields.SCHEDULTED_DEPARTURE_LOCAL));
		flight.setScheduledArrival(resultSet.getTimestamp(Fields.SCHEDULTED_ARRIVAL));
		flight.setScheduledArrivalLocal(resultSet.getTimestamp(Fields.SCHEDULTED_ARRIVAL_LOCAL));
		flight.setScheduledDuration(resultSet.getTimestamp(Fields.SCHEDULTED_DURATION));
		flight.setDepartureAirport(resultSet.getString(Fields.DEPARTURE_AIRPORT));
		flight.setDepartureAirportName(resultSet.getString(Fields.DEPARTURE_AIRPORT_NAME));
		flight.setDepartureCity(resultSet.getString(Fields.DEPARTURE_CITY));
		flight.setArrivalAirport(resultSet.getString(Fields.ARRIVAL_AIRPORT));
		flight.setArrivalAirportName(resultSet.getString(Fields.ARRIVAL_AIRPORT_NAME));
		flight.setArrivalCity(resultSet.getString(Fields.ARRIVAL_CITY));
		flight.setStatus(resultSet.getString(Fields.STATUS));
		flight.setAircraftCode(resultSet.getString(Fields.AIRCRAFT_CODE));
		flight.setActualDeparture(resultSet.getTimestamp(Fields.ACTUAL_DEPARTURE));
		flight.setActualDepartureLocal(resultSet.getTimestamp(Fields.ACTUAL_DEPARTURE_LOCAL));
		flight.setActualArrival(resultSet.getTimestamp(Fields.ACTUAL_ARRIVAL));
		flight.setActualArrivalLocal(resultSet.getTimestamp(Fields.ACTUAL_ARRIVAL_LOCAL));
		flight.setActualDuration(resultSet.getTimestamp(Fields.ACTUAL_DURATION));

		
		return flight;
	}

	class Fields {
		private static final String FLIGNT_ID = "flignt_id";
		private static final String FLIGHT_NUMBER = "flight_number";
		private static final String SCHEDULTED_DEPARTURE = "scheduled_departure";
		private static final String SCHEDULTED_DEPARTURE_LOCAL = "scheduled_departure_local";
		private static final String SCHEDULTED_ARRIVAL = "scheduled_arrival";
		private static final String SCHEDULTED_ARRIVAL_LOCAL = "scheduled_arrival_local";
		private static final String SCHEDULTED_DURATION = "scheduled_duration";
		private static final String DEPARTURE_AIRPORT = "departure_airport";
		private static final String DEPARTURE_AIRPORT_NAME = "departure_airport_name";
		private static final String DEPARTURE_CITY = "departure_city";
		private static final String ARRIVAL_AIRPORT = "arrival_airport";
		private static final String ARRIVAL_AIRPORT_NAME = "arrival_airport_name";
		private static final String ARRIVAL_CITY = "arrival_city";
		private static final String STATUS = "status";
		private static final String AIRCRAFT_CODE = "aircraft_code";
		private static final String ACTUAL_DEPARTURE = "actual_departure";
		private static final String ACTUAL_DEPARTURE_LOCAL = "actual_departure_local";
		private static final String ACTUAL_ARRIVAL = "actual_arrival";
		private static final String ACTUAL_ARRIVAL_LOCAL = "actual_arrival_local";
		private static final String ACTUAL_DURATION = "actual_duration";


	}

}
