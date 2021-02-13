package demo.op.composite.order.collector.comp.v2.helper;

import java.util.List;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;

public interface IOrderCollectorCoreV2CoreServiceHelper {

  com.abcd.uop.model.Order collectOrder(String serviceCallId);

  ServiceRequestContext processCollectOrderRequest(String serviceCallId);

  com.abcd.uop.model.Order processCollectOrderResponse(String serviceCallId);

  com.abcd.uop.model.Order processCollectOrderFallback(String serviceCallId, Throwable e);

  com.abcd.oop.model.Order updateOrder(String serviceCallId);

  ServiceRequestContext processUpdateOrderRequest(String serviceCallId);

  com.abcd.oop.model.Order processUpdateOrderResponse(String serviceCallId);

  com.abcd.oop.model.Order processUpdateOrderFallback(String serviceCallId, Throwable e);
}
