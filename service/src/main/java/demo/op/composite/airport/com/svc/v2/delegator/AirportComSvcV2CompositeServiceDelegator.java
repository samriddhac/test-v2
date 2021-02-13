package demo.op.composite.airport.com.svc.v2.delegator;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.future.FutureUtils;
import demo.cosmos.core.airport.model.Airport;
import demo.op.composite.airport.com.svc.v2.IAirportComSvcV2CompositeService;
import demo.op.composite.airport.com.svc.v2.helper.IAirportComSvcV2CompositeServiceHelper;
import demo.op.composite.airport.com.svc.v2.helper.IAirportCoreSvcV1CoreServiceHelper;
import java.lang.Override;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportComSvcV2CompositeServiceDelegator
    implements IAirportComSvcV2CompositeService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IAirportComSvcV2CompositeServiceHelper airportComSvcV2CompositeServiceHelper;

  private final IAirportCoreSvcV1CoreServiceHelper airportCoreSvcV1CoreServiceHelper;

  @Override
  public List<Airport> getAirports() {
    airportComSvcV2CompositeServiceHelper.processGetAirportsRequest();
    if (isServiceCallEnabled("35d5650f-0a31-4c78-997a-610e06c56a56")) {
      airportCoreSvcV1CoreServiceHelper.getAirports("35d5650f-0a31-4c78-997a-610e06c56a56");
    }
    return airportComSvcV2CompositeServiceHelper.processGetAirportsResponse();
  }

  @Override
  public void postAirports(Airport body) {
    airportComSvcV2CompositeServiceHelper.processPostAirportsRequest();
    if (isServiceCallEnabled("b154c323-5ac1-4fe2-b0d2-50f955ad1daa")) {
      airportCoreSvcV1CoreServiceHelper.postAirports("b154c323-5ac1-4fe2-b0d2-50f955ad1daa");
    }
    airportComSvcV2CompositeServiceHelper.processPostAirportsResponse();
  }

  @Override
  public Airport getAirport(long airportId) {
    airportComSvcV2CompositeServiceHelper.processGetAirportRequest();
    if (isServiceCallEnabled("11c5530e-86f2-4981-9365-6e8089d3586b")) {
      airportCoreSvcV1CoreServiceHelper.getAirport("11c5530e-86f2-4981-9365-6e8089d3586b");
    }
    return airportComSvcV2CompositeServiceHelper.processGetAirportResponse();
  }

  @Override
  public void putAirport(long airportId, Airport body) {
    airportComSvcV2CompositeServiceHelper.processPutAirportRequest();
    if (isServiceCallEnabled("20c04979-2001-424e-8441-70291243488d")) {
      airportCoreSvcV1CoreServiceHelper.putAirport("20c04979-2001-424e-8441-70291243488d");
    }
    airportComSvcV2CompositeServiceHelper.processPutAirportResponse();
  }

  @Override
  public void deleteAirport(long airportId) {
    airportComSvcV2CompositeServiceHelper.processDeleteAirportRequest();
    if (isServiceCallEnabled("d4f2d4e4-b262-49ce-8282-a99507541d4c")) {
      airportCoreSvcV1CoreServiceHelper.deleteAirport("d4f2d4e4-b262-49ce-8282-a99507541d4c");
    }
    airportComSvcV2CompositeServiceHelper.processDeleteAirportResponse();
  }
}
