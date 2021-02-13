package demo.op.composite.order.comp.v1.helper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import demo.op.composite.order.comp.v1.helper.IOrderCompV1CompositeServiceHelper;
import com.macys.uop.model.Order;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderCompV1CompositeServiceHelperImpl
    implements IOrderCompV1CompositeServiceHelper, ServiceExecutionContextUtil {

  @Override
  public void processCreateOrderRequest() {
    // TODO: your code goes here...
    enableServiceCall("c37db226-7bb4-4f3e-8d11-8f71c53e705a");
  }

  @Override
  public Order processCreateOrderResponse() {
    // TODO: your code goes here...
    return null;
  }
}
