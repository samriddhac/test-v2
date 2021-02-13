package demo.op.composite.airport.comp.svc.v1.delegator;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.future.FutureUtils;
import demo.cosmos.core.airport.model.Airport;
import demo.op.composite.airport.comp.svc.v1.IAirportCompSvcV1CompositeService;
import demo.op.composite.airport.comp.svc.v1.helper.IAirportCompSvcV1CompositeServiceHelper;
import demo.op.composite.airport.comp.svc.v1.helper.IAirportCoreSvcV1CoreServiceHelper;
import java.lang.Override;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportCompSvcV1CompositeServiceDelegator
    implements IAirportCompSvcV1CompositeService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IAirportCompSvcV1CompositeServiceHelper airportCompSvcV1CompositeServiceHelper;

  private final IAirportCoreSvcV1CoreServiceHelper airportCoreSvcV1CoreServiceHelper;

  @Override
  public List<Airport> getAirports() {
    airportCompSvcV1CompositeServiceHelper.processGetAirportsRequest();
    if (isServiceCallEnabled("b7bb0a18-b871-4db2-9ecc-ac2b82d0fa91")) {
      airportCoreSvcV1CoreServiceHelper.getAirports("b7bb0a18-b871-4db2-9ecc-ac2b82d0fa91");
    }
    return airportCompSvcV1CompositeServiceHelper.processGetAirportsResponse();
  }

  @Override
  public void postAirports(Airport body) {
    airportCompSvcV1CompositeServiceHelper.processPostAirportsRequest();
    if (isServiceCallEnabled("e9d4b99a-cea5-4323-940d-95ddd2a89bae")) {
      airportCoreSvcV1CoreServiceHelper.postAirports("e9d4b99a-cea5-4323-940d-95ddd2a89bae");
    }
    airportCompSvcV1CompositeServiceHelper.processPostAirportsResponse();
  }

  @Override
  public Airport getAirport(long airportId) {
    airportCompSvcV1CompositeServiceHelper.processGetAirportRequest();
    if (isServiceCallEnabled("18cb170f-2b4d-4c82-b194-055b6293b708")) {
      airportCoreSvcV1CoreServiceHelper.getAirport("18cb170f-2b4d-4c82-b194-055b6293b708");
    }
    return airportCompSvcV1CompositeServiceHelper.processGetAirportResponse();
  }

  @Override
  public void putAirport(long airportId, Airport body) {
    airportCompSvcV1CompositeServiceHelper.processPutAirportRequest();
    if (isServiceCallEnabled("5ffd7be8-549c-49a6-979f-6eea51b1a3d2")) {
      airportCoreSvcV1CoreServiceHelper.putAirport("5ffd7be8-549c-49a6-979f-6eea51b1a3d2");
    }
    airportCompSvcV1CompositeServiceHelper.processPutAirportResponse();
  }

  @Override
  public void deleteAirport(long airportId) {
    airportCompSvcV1CompositeServiceHelper.processDeleteAirportRequest();
    if (isServiceCallEnabled("619da8a3-3e79-447f-b1d7-fb0905bae029")) {
      airportCoreSvcV1CoreServiceHelper.deleteAirport("619da8a3-3e79-447f-b1d7-fb0905bae029");
    }
    airportCompSvcV1CompositeServiceHelper.processDeleteAirportResponse();
  }
}
