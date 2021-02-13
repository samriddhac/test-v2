package demo.op.composite.group.comp.svc.v1.helper;

import java.util.List;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import com.abcd.uop.model.Order;

public interface IGroupCoreSvcV1CoreServiceHelper {

  List<List<Order>> groupLogicalShipments(String serviceCallId);

  ServiceRequestContext processGroupLogicalShipmentsRequest(String serviceCallId);

  List<List<Order>> processGroupLogicalShipmentsResponse(String serviceCallId);

  List<List<Order>> processGroupLogicalShipmentsFallback(String serviceCallId, Throwable e);
}
