package demo.op.composite.airport.comp.svc.v1.helper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import demo.op.composite.airport.comp.svc.v1.helper.IAirportCompSvcV1CompositeServiceHelper;
import demo.cosmos.core.airport.model.Airport;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AirportCompSvcV1CompositeServiceHelperImpl
    implements IAirportCompSvcV1CompositeServiceHelper, ServiceExecutionContextUtil {

  @Override
  public void processGetAirportsRequest() {
    // TODO: your code goes here...
    enableServiceCall("b7bb0a18-b871-4db2-9ecc-ac2b82d0fa91");
  }

  @Override
  public List<Airport> processGetAirportsResponse() {
    // TODO: your code goes here...
    return Collections.emptyList();
  }

  @Override
  public void processPostAirportsRequest() {
    // TODO: your code goes here...
    enableServiceCall("e9d4b99a-cea5-4323-940d-95ddd2a89bae");
  }

  @Override
  public void processPostAirportsResponse() {
    // TODO: your code goes here...
  }

  @Override
  public void processGetAirportRequest() {
    // TODO: your code goes here...
    enableServiceCall("18cb170f-2b4d-4c82-b194-055b6293b708");
  }

  @Override
  public Airport processGetAirportResponse() {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processPutAirportRequest() {
    // TODO: your code goes here...
    enableServiceCall("5ffd7be8-549c-49a6-979f-6eea51b1a3d2");
  }

  @Override
  public void processPutAirportResponse() {
    // TODO: your code goes here...
  }

  @Override
  public void processDeleteAirportRequest() {
    // TODO: your code goes here...
    enableServiceCall("619da8a3-3e79-447f-b1d7-fb0905bae029");
  }

  @Override
  public void processDeleteAirportResponse() {
    // TODO: your code goes here...
  }
}
