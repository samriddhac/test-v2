package demo.op.composite.group.comp.svc.v1;

import java.util.List;
import com.abcd.uop.model.Order;

/** */
public interface IGroupCompSvcV1CompositeService {

  public List<List<Order>> groupLogicalShipments(List<Order> lineItemArray);
}
