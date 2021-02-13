package demo.op.composite.order.primitive.comp.v2.helper;

import java.util.List;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;

public interface IOrderPrimitiveCoreV1CoreServiceHelper {

  Double getOrderIdForCustomerOrderIdOrReservationId(String serviceCallId);

  ServiceRequestContext processGetOrderIdForCustomerOrderIdOrReservationIdRequest(
      String serviceCallId);

  Double processGetOrderIdForCustomerOrderIdOrReservationIdResponse(String serviceCallId);

  Double processGetOrderIdForCustomerOrderIdOrReservationIdFallback(
      String serviceCallId, Throwable e);
}
