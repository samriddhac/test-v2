package demo.op.core.order.core.v1.dao;

import java.util.*;
import com.macys.uop.model.Order;

public interface IOrderCoreV1CoreDao {

  Order createOrder(Order body);
}
