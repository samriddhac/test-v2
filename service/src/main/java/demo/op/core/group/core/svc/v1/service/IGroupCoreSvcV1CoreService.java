package demo.op.core.group.core.svc.v1.service;

import java.util.*;
import com.abcd.uop.model.Order;

public interface IGroupCoreSvcV1CoreService {

  List<List<Order>> groupLogicalShipments(List<Order> lineItemArray);
}
