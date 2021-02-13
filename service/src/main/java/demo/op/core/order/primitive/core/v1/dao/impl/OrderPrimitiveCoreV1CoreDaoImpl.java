package demo.op.core.order.primitive.core.v1.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.stereotype.Component;

import demo.op.core.order.primitive.core.v1.dao.OrderPrimitiveCoreV1CoreDao;

import com.google.cloud.spanner.Key;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderPrimitiveCoreV1CoreDaoImpl implements OrderPrimitiveCoreV1CoreDao {

  private final SpannerTemplate spannerTemplate;

  public Double getOrderIdForCustomerOrderIdOrReservationId() {
    // TODO: your code goes here...
    return null;
  }
}
