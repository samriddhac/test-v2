package demo.op.composite.airport.comp.svc.v1.helper.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import demo.op.composite.airport.comp.svc.v1.helper.AbstractAirportCoreSvcV1CoreServiceHelper;
import demo.cosmos.core.airport.model.Airport;

@Component
public class AirportCoreSvcV1CoreServiceHelperImpl
    extends AbstractAirportCoreSvcV1CoreServiceHelper {

  public AirportCoreSvcV1CoreServiceHelperImpl(RestTemplate restTemplate, Logger logger) {
    super(restTemplate, logger);
  }

  @Override
  public ServiceRequestContext processGetAirportsRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public List<Airport> processGetAirportsResponse(String serviceCallId) {
    // TODO: your code goes here...
    return Collections.emptyList();
  }

  @Override
  public List<Airport> processGetAirportsFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
    return Collections.emptyList();
  }

  @Override
  public ServiceRequestContext processPostAirportsRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public void processPostAirportsResponse(String serviceCallId) {
    // TODO: your code goes here...
  }

  @Override
  public void processPostAirportsFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceRequestContext processGetAirportRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public Airport processGetAirportResponse(String serviceCallId) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public Airport processGetAirportFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public ServiceRequestContext processPutAirportRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public void processPutAirportResponse(String serviceCallId) {
    // TODO: your code goes here...
  }

  @Override
  public void processPutAirportFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceRequestContext processDeleteAirportRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public void processDeleteAirportResponse(String serviceCallId) {
    // TODO: your code goes here...
  }

  @Override
  public void processDeleteAirportFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
  }
}
