package demo.op.composite.order.collector.comp.v2.helper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import demo.op.composite.order.collector.comp.v2.helper.IOrderCollectorCompV2CompositeServiceHelper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderCollectorCompV2CompositeServiceHelperImpl
    implements IOrderCollectorCompV2CompositeServiceHelper, ServiceExecutionContextUtil {

  @Override
  public void processCollectOrderRequest() {
    // TODO: your code goes here...
    enableServiceCall("1a251842-c387-4b06-aa56-92470b302ccd");
  }

  @Override
  public com.abcd.uop.model.Order processCollectOrderResponse() {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processUpdateOrderRequest() {
    // TODO: your code goes here...
    enableServiceCall("8269d5ce-000a-4bf5-a996-b431edfaaa02");
  }

  @Override
  public com.abcd.oop.model.Order processUpdateOrderResponse() {
    // TODO: your code goes here...
    return null;
  }
}
