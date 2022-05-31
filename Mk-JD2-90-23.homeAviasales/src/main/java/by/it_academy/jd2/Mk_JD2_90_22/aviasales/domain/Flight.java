package by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Flight {
    private  Long flightId;
    private  String flightNo;
    private  Timestamp scheduledDeparture;
    private  Timestamp scheduledDepartureLocal;
    private  Timestamp scheduledArrival;
    private  Timestamp scheduledArrivalLocal;
    private  Timestamp scheduledDuration;
    private  String departureAirport;
    private  String departureAirportName;
    private  String departureCity;
    private  String arrivalAirport;
    private  String arrivalAirportName;
    private  String arrivalCity;
    private  String status;
    private  String aircraftCode;
    private  Timestamp actualDeparture;
    private  Timestamp actualDepartureLocal;
    private  Timestamp actualArrival;
    private  Timestamp actualArrivalLocal;
    private  Timestamp actualDuration;
    
	public  Flight() {
		super();
	}

	public Flight(Long flightId, String flightNo, Timestamp scheduledDeparture, Timestamp scheduledDepartureLocal,
			Timestamp scheduledArrival, Timestamp scheduledArrivalLocal, Timestamp scheduledDuration,
			String departureAirport, String departureAirportName, String departureCity, String arrivalAirport,
			String arrivalAirportName, String arrivalCity, String status, String aircraftCode,
			Timestamp actualDeparture, Timestamp actualDepartureLocal, Timestamp actualArrival,
			Timestamp actualArrivalLocal, Timestamp actualDuration) {
		super();
		this.flightId = flightId;
		this.flightNo = flightNo;
		this.scheduledDeparture = scheduledDeparture;
		this.scheduledDepartureLocal = scheduledDepartureLocal;
		this.scheduledArrival = scheduledArrival;
		this.scheduledArrivalLocal = scheduledArrivalLocal;
		this.scheduledDuration = scheduledDuration;
		this.departureAirport = departureAirport;
		this.departureAirportName = departureAirportName;
		this.departureCity = departureCity;
		this.arrivalAirport = arrivalAirport;
		this.arrivalAirportName = arrivalAirportName;
		this.arrivalCity = arrivalCity;
		this.status = status;
		this.aircraftCode = aircraftCode;
		this.actualDeparture = actualDeparture;
		this.actualDepartureLocal = actualDepartureLocal;
		this.actualArrival = actualArrival;
		this.actualArrivalLocal = actualArrivalLocal;
		this.actualDuration = actualDuration;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Timestamp getScheduledDeparture() {
		return scheduledDeparture;
	}

	public void setScheduledDeparture(Timestamp scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}

	public Timestamp getScheduledDepartureLocal() {
		return scheduledDepartureLocal;
	}

	public void setScheduledDepartureLocal(Timestamp scheduledDepartureLocal) {
		this.scheduledDepartureLocal = scheduledDepartureLocal;
	}

	public Timestamp getScheduledArrival() {
		return scheduledArrival;
	}

	public void setScheduledArrival(Timestamp scheduledArrival) {
		this.scheduledArrival = scheduledArrival;
	}

	public Timestamp getScheduledArrivalLocal() {
		return scheduledArrivalLocal;
	}

	public void setScheduledArrivalLocal(Timestamp scheduledArrivalLocal) {
		this.scheduledArrivalLocal = scheduledArrivalLocal;
	}

	public Timestamp getScheduledDuration() {
		return scheduledDuration;
	}

	public void setScheduledDuration(Timestamp scheduledDuration) {
		this.scheduledDuration = scheduledDuration;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

	public Timestamp getActualDeparture() {
		return actualDeparture;
	}

	public void setActualDeparture(Timestamp actualDeparture) {
		this.actualDeparture = actualDeparture;
	}

	public Timestamp getActualDepartureLocal() {
		return actualDepartureLocal;
	}

	public void setActualDepartureLocal(Timestamp actualDepartureLocal) {
		this.actualDepartureLocal = actualDepartureLocal;
	}

	public Timestamp getActualArrival() {
		return actualArrival;
	}

	public void setActualArrival(Timestamp actualArrival) {
		this.actualArrival = actualArrival;
	}

	public Timestamp getActualArrivalLocal() {
		return actualArrivalLocal;
	}

	public void setActualArrivalLocal(Timestamp actualArrivalLocal) {
		this.actualArrivalLocal = actualArrivalLocal;
	}

	public Timestamp getActualDuration() {
		return actualDuration;
	}

	public void setActualDuration(Timestamp actualDuration) {
		this.actualDuration = actualDuration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actualArrival, actualArrivalLocal, actualDeparture, actualDepartureLocal, actualDuration,
				aircraftCode, arrivalAirport, arrivalAirportName, arrivalCity, departureAirport, departureAirportName,
				departureCity, flightId, flightNo, scheduledArrival, scheduledArrivalLocal, scheduledDeparture,
				scheduledDepartureLocal, scheduledDuration, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(actualArrival, other.actualArrival)
				&& Objects.equals(actualArrivalLocal, other.actualArrivalLocal)
				&& Objects.equals(actualDeparture, other.actualDeparture)
				&& Objects.equals(actualDepartureLocal, other.actualDepartureLocal)
				&& Objects.equals(actualDuration, other.actualDuration)
				&& Objects.equals(aircraftCode, other.aircraftCode)
				&& Objects.equals(arrivalAirport, other.arrivalAirport)
				&& Objects.equals(arrivalAirportName, other.arrivalAirportName)
				&& Objects.equals(arrivalCity, other.arrivalCity)
				&& Objects.equals(departureAirport, other.departureAirport)
				&& Objects.equals(departureAirportName, other.departureAirportName)
				&& Objects.equals(departureCity, other.departureCity) && Objects.equals(flightId, other.flightId)
				&& Objects.equals(flightNo, other.flightNo) && Objects.equals(scheduledArrival, other.scheduledArrival)
				&& Objects.equals(scheduledArrivalLocal, other.scheduledArrivalLocal)
				&& Objects.equals(scheduledDeparture, other.scheduledDeparture)
				&& Objects.equals(scheduledDepartureLocal, other.scheduledDepartureLocal)
				&& Objects.equals(scheduledDuration, other.scheduledDuration) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNo=" + flightNo + ", scheduledDeparture=" + scheduledDeparture
				+ ", scheduledDepartureLocal=" + scheduledDepartureLocal + ", scheduledArrival=" + scheduledArrival
				+ ", scheduledArrivalLocal=" + scheduledArrivalLocal + ", scheduledDuration=" + scheduledDuration
				+ ", departureAirport=" + departureAirport + ", departureAirportName=" + departureAirportName
				+ ", departureCity=" + departureCity + ", arrivalAirport=" + arrivalAirport + ", arrivalAirportName="
				+ arrivalAirportName + ", arrivalCity=" + arrivalCity + ", status=" + status + ", aircraftCode="
				+ aircraftCode + ", actualDeparture=" + actualDeparture + ", actualDepartureLocal="
				+ actualDepartureLocal + ", actualArrival=" + actualArrival + ", actualArrivalLocal="
				+ actualArrivalLocal + ", actualDuration=" + actualDuration + "]";
	}

}
