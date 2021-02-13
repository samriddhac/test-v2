package demo.op.core.order.core.v1.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import demo.op.core.order.core.v1.dao.OrderCoreV1CoreDao;
import com.macys.uop.model.Order;
import demo.op.core.order.core.v1.service.OrderCoreV1CoreService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCoreV1CoreServiceImpl implements OrderCoreV1CoreService {

  private final OrderCoreV1CoreDao orderCoreV1CoreDao;

  @Override
  public Order createOrder(Order body) {
    // HINT: your code goes here...
    return orderCoreV1CoreDao.createOrder(body);
  }
}
