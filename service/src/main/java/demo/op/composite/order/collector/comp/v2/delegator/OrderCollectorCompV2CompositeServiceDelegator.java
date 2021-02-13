package demo.op.composite.order.collector.comp.v2.delegator;

import com.abcd.uop.model.Order;
import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.future.FutureUtils;
import demo.op.composite.order.collector.comp.v2.IOrderCollectorCompV2CompositeService;
import demo.op.composite.order.collector.comp.v2.helper.IOrderCollectorCompV2CompositeServiceHelper;
import demo.op.composite.order.collector.comp.v2.helper.IOrderCollectorCoreV2CoreServiceHelper;
import java.lang.Override;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCollectorCompV2CompositeServiceDelegator
    implements IOrderCollectorCompV2CompositeService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IOrderCollectorCompV2CompositeServiceHelper
      orderCollectorCompV2CompositeServiceHelper;

  private final IOrderCollectorCoreV2CoreServiceHelper orderCollectorCoreV2CoreServiceHelper;

  @Override
  public Order collectOrder(Order body) {
    orderCollectorCompV2CompositeServiceHelper.processCollectOrderRequest();
    if (isServiceCallEnabled("1a251842-c387-4b06-aa56-92470b302ccd")) {
      orderCollectorCoreV2CoreServiceHelper.collectOrder("1a251842-c387-4b06-aa56-92470b302ccd");
    }
    return orderCollectorCompV2CompositeServiceHelper.processCollectOrderResponse();
  }

  @Override
  public com.abcd.oop.model.Order updateOrder(com.abcd.oop.model.Order body) {
    orderCollectorCompV2CompositeServiceHelper.processUpdateOrderRequest();
    if (isServiceCallEnabled("8269d5ce-000a-4bf5-a996-b431edfaaa02")) {
      orderCollectorCoreV2CoreServiceHelper.updateOrder("8269d5ce-000a-4bf5-a996-b431edfaaa02");
    }
    return orderCollectorCompV2CompositeServiceHelper.processUpdateOrderResponse();
  }
}
