package demo.op.core.group.core.svc.v1.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.stereotype.Component;

import demo.op.core.group.core.svc.v1.dao.GroupCoreSvcV1CoreDao;
import demo.op.core.group.core.svc.v1.dao.mapper.OrderToOrderMapper;

import com.abcd.uop.model.Order;
import com.google.cloud.spanner.Key;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GroupCoreSvcV1CoreDaoImpl implements GroupCoreSvcV1CoreDao {

  private final OrderToOrderMapper orderToOrderMapper;
  private final SpannerTemplate spannerTemplate;

  @Override
  public List<List<Order>> groupLogicalShipments(List<Order> lineItemArray) {
    // TODO: your code goes here...
    Long id = System.nanoTime();
    spannerTemplate.insert(orderToOrderMapper.convertToEntity(lineItemArray));
    return null;
  }
}
