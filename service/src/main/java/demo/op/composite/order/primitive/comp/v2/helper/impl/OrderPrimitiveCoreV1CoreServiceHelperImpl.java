package demo.op.composite.order.primitive.comp.v2.helper.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import demo.op.composite.order.primitive.comp.v2.helper.AbstractOrderPrimitiveCoreV1CoreServiceHelper;

@Component
public class OrderPrimitiveCoreV1CoreServiceHelperImpl
    extends AbstractOrderPrimitiveCoreV1CoreServiceHelper {

  public OrderPrimitiveCoreV1CoreServiceHelperImpl(RestTemplate restTemplate, Logger logger) {
    super(restTemplate, logger);
  }

  @Override
  public ServiceRequestContext processGetOrderIdForCustomerOrderIdOrReservationIdRequest(
      String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public Double processGetOrderIdForCustomerOrderIdOrReservationIdResponse(String serviceCallId) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public Double processGetOrderIdForCustomerOrderIdOrReservationIdFallback(
      String serviceCallId, Throwable e) {
    // TODO: your code goes here...
    return null;
  }
}
