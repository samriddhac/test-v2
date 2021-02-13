package demo.op.composite.order.collector.comp.v2.helper.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import demo.op.composite.order.collector.comp.v2.helper.AbstractOrderCollectorCoreV2CoreServiceHelper;

@Component
public class OrderCollectorCoreV2CoreServiceHelperImpl
    extends AbstractOrderCollectorCoreV2CoreServiceHelper {

  public OrderCollectorCoreV2CoreServiceHelperImpl(RestTemplate restTemplate, Logger logger) {
    super(restTemplate, logger);
  }

  @Override
  public ServiceRequestContext processCollectOrderRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public com.abcd.uop.model.Order processCollectOrderResponse(String serviceCallId) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public com.abcd.uop.model.Order processCollectOrderFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public ServiceRequestContext processUpdateOrderRequest(String serviceCallId) {
    // TODO: your code goes here...
    return new ServiceRequestContext();
  }

  @Override
  public com.abcd.oop.model.Order processUpdateOrderResponse(String serviceCallId) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public com.abcd.oop.model.Order processUpdateOrderFallback(String serviceCallId, Throwable e) {
    // TODO: your code goes here...
    return null;
  }
}
