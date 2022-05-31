package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.domain.Airport;

public interface IAirportDAO {

    List<Airport> getAll();

    Airport get(String code);

}
