package demo.op.composite.airport.com.svc.v2.helper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import demo.op.composite.airport.com.svc.v2.helper.IAirportComSvcV2CompositeServiceHelper;
import demo.cosmos.core.airport.model.Airport;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AirportComSvcV2CompositeServiceHelperImpl
    implements IAirportComSvcV2CompositeServiceHelper, ServiceExecutionContextUtil {

  @Override
  public void processGetAirportsRequest() {
    // TODO: your code goes here...
    enableServiceCall("35d5650f-0a31-4c78-997a-610e06c56a56");
  }

  @Override
  public List<Airport> processGetAirportsResponse() {
    // TODO: your code goes here...
    return Collections.emptyList();
  }

  @Override
  public void processPostAirportsRequest() {
    // TODO: your code goes here...
    enableServiceCall("b154c323-5ac1-4fe2-b0d2-50f955ad1daa");
  }

  @Override
  public void processPostAirportsResponse() {
    // TODO: your code goes here...
  }

  @Override
  public void processGetAirportRequest() {
    // TODO: your code goes here...
    enableServiceCall("11c5530e-86f2-4981-9365-6e8089d3586b");
  }

  @Override
  public Airport processGetAirportResponse() {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processPutAirportRequest() {
    // TODO: your code goes here...
    enableServiceCall("20c04979-2001-424e-8441-70291243488d");
  }

  @Override
  public void processPutAirportResponse() {
    // TODO: your code goes here...
  }

  @Override
  public void processDeleteAirportRequest() {
    // TODO: your code goes here...
    enableServiceCall("d4f2d4e4-b262-49ce-8282-a99507541d4c");
  }

  @Override
  public void processDeleteAirportResponse() {
    // TODO: your code goes here...
  }
}
