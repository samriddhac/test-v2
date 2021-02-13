package demo.op.composite.order.comp.v1.helper;

import java.util.List;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import com.macys.uop.model.Order;

public interface IOrderCoreV1CoreServiceHelper {

  Order createOrder(String serviceCallId);

  ServiceRequestContext processCreateOrderRequest(String serviceCallId);

  Order processCreateOrderResponse(String serviceCallId);

  Order processCreateOrderFallback(String serviceCallId, Throwable e);
}
