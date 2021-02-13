package demo.op.core.group.core.svc.v1.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import demo.op.core.group.core.svc.v1.dao.GroupCoreSvcV1CoreDao;
import com.abcd.uop.model.Order;
import demo.op.core.group.core.svc.v1.service.GroupCoreSvcV1CoreService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupCoreSvcV1CoreServiceImpl implements GroupCoreSvcV1CoreService {

  private final GroupCoreSvcV1CoreDao groupCoreSvcV1CoreDao;

  @Override
  public List<List<Order>> groupLogicalShipments(List<Order> lineItemArray) {
    // HINT: your code goes here...
    return groupCoreSvcV1CoreDao.groupLogicalShipments(lineItemArray);
  }
}
