package demo.op.core.order.collector.core.v2.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import demo.op.core.order.collector.core.v2.dao.OrderCollectorCoreV2CoreDao;
import demo.op.core.order.collector.core.v2.service.OrderCollectorCoreV2CoreService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCollectorCoreV2CoreServiceImpl implements OrderCollectorCoreV2CoreService {

  private final OrderCollectorCoreV2CoreDao orderCollectorCoreV2CoreDao;

  @Override
  public com.abcd.uop.model.Order collectOrder(com.abcd.uop.model.Order body) {
    // HINT: your code goes here...
    return orderCollectorCoreV2CoreDao.collectOrder(body);
  }

  public com.abcd.oop.model.Order updateOrder(com.abcd.oop.model.Order body) {
    // HINT: your code goes here...
    return orderCollectorCoreV2CoreDao.updateOrder(body);
  }
}
