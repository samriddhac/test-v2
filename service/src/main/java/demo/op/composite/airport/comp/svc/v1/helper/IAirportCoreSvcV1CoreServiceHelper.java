package demo.op.composite.airport.comp.svc.v1.helper;

import java.util.List;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import demo.cosmos.core.airport.model.Airport;

public interface IAirportCoreSvcV1CoreServiceHelper {

  List<Airport> getAirports(String serviceCallId);

  ServiceRequestContext processGetAirportsRequest(String serviceCallId);

  List<Airport> processGetAirportsResponse(String serviceCallId);

  List<Airport> processGetAirportsFallback(String serviceCallId, Throwable e);

  Object postAirports(String serviceCallId);

  ServiceRequestContext processPostAirportsRequest(String serviceCallId);

  void processPostAirportsResponse(String serviceCallId);

  void processPostAirportsFallback(String serviceCallId, Throwable e);

  Airport getAirport(String serviceCallId);

  ServiceRequestContext processGetAirportRequest(String serviceCallId);

  Airport processGetAirportResponse(String serviceCallId);

  Airport processGetAirportFallback(String serviceCallId, Throwable e);

  Object putAirport(String serviceCallId);

  ServiceRequestContext processPutAirportRequest(String serviceCallId);

  void processPutAirportResponse(String serviceCallId);

  void processPutAirportFallback(String serviceCallId, Throwable e);

  Object deleteAirport(String serviceCallId);

  ServiceRequestContext processDeleteAirportRequest(String serviceCallId);

  void processDeleteAirportResponse(String serviceCallId);

  void processDeleteAirportFallback(String serviceCallId, Throwable e);
}
