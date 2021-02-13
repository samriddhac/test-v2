package demo.op.core.order.collector.core.v2.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.stereotype.Component;

import demo.op.core.order.collector.core.v2.dao.OrderCollectorCoreV2CoreDao;
import demo.op.core.order.collector.core.v2.dao.mapper.OrderOneToOrderOneMapper;
import demo.op.core.order.collector.core.v2.dao.mapper.OrderTwoToOrderTwoMapper;

import com.google.cloud.spanner.Key;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderCollectorCoreV2CoreDaoImpl implements OrderCollectorCoreV2CoreDao {

  private final OrderOneToOrderOneMapper orderOneToOrderOneMapper;
  private final OrderTwoToOrderTwoMapper orderTwoToOrderTwoMapper;
  private final SpannerTemplate spannerTemplate;

  @Override
  public com.abcd.uop.model.Order collectOrder(com.abcd.uop.model.Order body) {
    // TODO: your code goes here...
    Long id = System.nanoTime();
    spannerTemplate.insert(orderOneToOrderOneMapper.convertToEntity(body));
    return null;
  }

  public com.abcd.oop.model.Order updateOrder(com.abcd.oop.model.Order body) {
    // HINT: your code goes here...
    spannerTemplate.update(orderTwoToOrderTwoMapper.convertToEntity(body));
    return null;
  }
}
