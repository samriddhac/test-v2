package demo.op.core.airport.core.svc.v1.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.stereotype.Component;

import demo.op.core.airport.core.svc.v1.dao.AirportCoreSvcV1CoreDao;
import demo.op.core.airport.core.svc.v1.dao.mapper.*;

import demo.cosmos.core.airport.model.Airport;
import com.google.cloud.spanner.Key;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AirportCoreSvcV1CoreDaoImpl implements AirportCoreSvcV1CoreDao {

  private final AirportToAirportMapper airportToAirportMapper;
  private final SpannerTemplate spannerTemplate;

  @Override
  public List<Airport> getAirports() {
    // HINT: your code goes here...
    return spannerTemplate.readAll(demo.op.core.airport.core.svc.v1.dao.entity.OrderMaster.class)
        .stream()
        .map(airportToAirportMapper::convertToResource)
        .collect(Collectors.toList());
  }

  @Override
  public void postAirports(Airport body) {
    // TODO: your code goes here...
    Long id = System.nanoTime();
    spannerTemplate.insert(airportToAirportMapper.convertToEntity(body));
  }

  @Override
  public Airport getAirport(long airportId) {
    // HINT: your code goes here...
    Key key = Key.newBuilder().append(airportId).build();
    demo.op.core.airport.core.svc.v1.dao.entity.OrderMaster orderMasterEntity =
        spannerTemplate.read(demo.op.core.airport.core.svc.v1.dao.entity.OrderMaster.class, key);
    Airport airport = null;
    if (orderMasterEntity != null) {
      airport = airportToAirportMapper.convertToResource(orderMasterEntity);
    }
    return airport;
  }

  public void putAirport(long airportId, Airport body) {
    // HINT: your code goes here...
    spannerTemplate.update(airportToAirportMapper.convertToEntity(body));
  }

  public void deleteAirport(long airportId) {
    // HINT: your code goes here...
    Key key = Key.newBuilder().append(airportId).build();
    demo.op.core.airport.core.svc.v1.dao.entity.OrderMaster orderMasterEntity =
        spannerTemplate.read(demo.op.core.airport.core.svc.v1.dao.entity.OrderMaster.class, key);
    if (orderMasterEntity != null) {
      spannerTemplate.delete(orderMasterEntity);
    }
  }
}
