package demo.op.composite.airport.comp.svc.v1.helper;

import java.util.List;
import demo.cosmos.core.airport.model.Airport;

public interface IAirportCompSvcV1CompositeServiceHelper {

  public void processGetAirportsRequest();

  public List<Airport> processGetAirportsResponse();

  public void processPostAirportsRequest();

  public void processPostAirportsResponse();

  public void processGetAirportRequest();

  public Airport processGetAirportResponse();

  public void processPutAirportRequest();

  public void processPutAirportResponse();

  public void processDeleteAirportRequest();

  public void processDeleteAirportResponse();
}
