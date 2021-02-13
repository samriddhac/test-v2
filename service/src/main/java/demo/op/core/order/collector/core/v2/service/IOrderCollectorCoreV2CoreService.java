package demo.op.core.order.collector.core.v2.service;

import java.util.*;

public interface IOrderCollectorCoreV2CoreService {

  com.abcd.uop.model.Order collectOrder(com.abcd.uop.model.Order body);

  com.abcd.oop.model.Order updateOrder(com.abcd.oop.model.Order body);
}
