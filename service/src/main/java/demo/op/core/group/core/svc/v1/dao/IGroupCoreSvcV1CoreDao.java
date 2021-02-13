package demo.op.core.group.core.svc.v1.dao;

import java.util.*;
import com.abcd.uop.model.Order;

public interface IGroupCoreSvcV1CoreDao {

  List<List<Order>> groupLogicalShipments(List<Order> lineItemArray);
}
