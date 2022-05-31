package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Flight;

public interface IFlightDAO {

    List<Flight> getAll();

    Flight get(Long id);

}
