package demo.op.core.order.collector.core.v1.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import demo.op.core.order.collector.core.v1.dao.OrderCollectorCoreV1CoreDao;
import com.macys.uop.model.Order;
import demo.op.core.order.collector.core.v1.service.OrderCollectorCoreV1CoreService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCollectorCoreV1CoreServiceImpl implements OrderCollectorCoreV1CoreService {

  private final OrderCollectorCoreV1CoreDao orderCollectorCoreV1CoreDao;

  @Override
  public Order createOrder(Order body) {
    // HINT: your code goes here...
    return orderCollectorCoreV1CoreDao.createOrder(body);
  }
}
