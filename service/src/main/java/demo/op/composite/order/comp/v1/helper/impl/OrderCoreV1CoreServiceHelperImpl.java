package demo.op.composite.order.comp.v1.helper.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import demo.op.composite.order.comp.v1.helper.AbstractOrderCoreV1CoreServiceHelper;
import com.macys.uop.model.Order;

@Component
public class OrderCoreV1CoreServiceHelperImpl extends AbstractOrderCoreV1CoreServiceHelper {

  public OrderCoreV1CoreServiceHelperImpl(RestTemplate restTemplate, Logger logger) {
    super(restTemplate, logger);
  }

  @Override
  public ServiceRequestContext processCreateOrderRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public Order processCreateOrderResponse(String serviceCallId) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public Order processCreateOrderFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
    return null;
  }
}
