package demo.op.composite.group.comp.svc.v1.helper;

import java.util.List;
import com.abcd.uop.model.Order;

public interface IGroupCompSvcV1CompositeServiceHelper {

  public void processGroupLogicalShipmentsRequest();

  public List<List<Order>> processGroupLogicalShipmentsResponse();
}
