package demo.op.core.order.primitive.core.v1.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import demo.op.core.order.primitive.core.v1.dao.OrderPrimitiveCoreV1CoreDao;
import demo.op.core.order.primitive.core.v1.service.OrderPrimitiveCoreV1CoreService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderPrimitiveCoreV1CoreServiceImpl implements OrderPrimitiveCoreV1CoreService {

  private final OrderPrimitiveCoreV1CoreDao orderPrimitiveCoreV1CoreDao;

  public Double getOrderIdForCustomerOrderIdOrReservationId() {
    // TODO: your code goes here...
    return null;
  }
}
