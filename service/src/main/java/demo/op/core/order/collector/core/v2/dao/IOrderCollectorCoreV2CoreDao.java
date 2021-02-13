package demo.op.core.order.collector.core.v2.dao;

import java.util.*;

public interface IOrderCollectorCoreV2CoreDao {

  com.abcd.uop.model.Order collectOrder(com.abcd.uop.model.Order body);

  com.abcd.oop.model.Order updateOrder(com.abcd.oop.model.Order body);
}
