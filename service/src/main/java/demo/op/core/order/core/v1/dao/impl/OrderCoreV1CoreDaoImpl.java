package demo.op.core.order.core.v1.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.stereotype.Component;

import demo.op.core.order.core.v1.dao.OrderCoreV1CoreDao;
import demo.op.core.order.core.v1.dao.mapper.OrderToOrderMapper;

import com.macys.uop.model.Order;
import com.google.cloud.spanner.Key;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderCoreV1CoreDaoImpl implements OrderCoreV1CoreDao {

  private final OrderToOrderMapper orderToOrderMapper;
  private final SpannerTemplate spannerTemplate;

  @Override
  public Order createOrder(Order body) {
    // TODO: your code goes here...
    Long id = System.nanoTime();
    spannerTemplate.insert(orderToOrderMapper.convertToEntity(body));
    return body;
  }
}
