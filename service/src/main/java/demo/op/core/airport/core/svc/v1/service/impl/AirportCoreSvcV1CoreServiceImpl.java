package demo.op.core.airport.core.svc.v1.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import demo.op.core.airport.core.svc.v1.dao.AirportCoreSvcV1CoreDao;
import demo.cosmos.core.airport.model.Airport;
import demo.op.core.airport.core.svc.v1.service.AirportCoreSvcV1CoreService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AirportCoreSvcV1CoreServiceImpl implements AirportCoreSvcV1CoreService {

  private final AirportCoreSvcV1CoreDao airportCoreSvcV1CoreDao;

  @Override
  public List<Airport> getAirports() {
    // HINT: your code goes here...
    return airportCoreSvcV1CoreDao.getAirports();
  }

  @Override
  public void postAirports(Airport body) {
    // HINT: your code goes here...
    airportCoreSvcV1CoreDao.postAirports(body);
  }

  @Override
  public Airport getAirport(long airportId) {
    // HINT: your code goes here...
    return airportCoreSvcV1CoreDao.getAirport(airportId);
  }

  public void putAirport(long airportId, Airport body) {
    // HINT: your code goes here...
    airportCoreSvcV1CoreDao.putAirport(airportId, body);
  }

  public void deleteAirport(long airportId) {
    // HINT: your code goes here...
    airportCoreSvcV1CoreDao.deleteAirport(airportId);
  }
}
