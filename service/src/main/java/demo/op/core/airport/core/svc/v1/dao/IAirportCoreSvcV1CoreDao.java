package demo.op.core.airport.core.svc.v1.dao;

import java.util.*;
import demo.cosmos.core.airport.model.Airport;

public interface IAirportCoreSvcV1CoreDao {

  List<Airport> getAirports();

  void postAirports(Airport body);

  Airport getAirport(long airportId);

  void putAirport(long airportId, Airport body);

  void deleteAirport(long airportId);
}
