package demo.op.composite.airport.comp.svc.v1;

import java.util.List;
import demo.cosmos.core.airport.model.Airport;

/** */
public interface IAirportCompSvcV1CompositeService {

  public List<Airport> getAirports();

  void postAirports(Airport body);

  public Airport getAirport(long airportId);

  void putAirport(long airportId, Airport body);

  void deleteAirport(long airportId);
}
