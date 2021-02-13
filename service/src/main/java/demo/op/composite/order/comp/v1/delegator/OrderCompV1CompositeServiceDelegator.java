package demo.op.composite.order.comp.v1.delegator;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.future.FutureUtils;
import com.macys.uop.model.Order;
import demo.op.composite.order.comp.v1.IOrderCompV1CompositeService;
import demo.op.composite.order.comp.v1.helper.IOrderCompV1CompositeServiceHelper;
import demo.op.composite.order.comp.v1.helper.IOrderCoreV1CoreServiceHelper;
import java.lang.Override;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCompV1CompositeServiceDelegator
    implements IOrderCompV1CompositeService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IOrderCompV1CompositeServiceHelper orderCompV1CompositeServiceHelper;

  private final IOrderCoreV1CoreServiceHelper orderCoreV1CoreServiceHelper;

  @Override
  public Order createOrder(Order body) {
    orderCompV1CompositeServiceHelper.processCreateOrderRequest();
    if (isServiceCallEnabled("c37db226-7bb4-4f3e-8d11-8f71c53e705a")) {
      orderCoreV1CoreServiceHelper.createOrder("c37db226-7bb4-4f3e-8d11-8f71c53e705a");
    }
    return orderCompV1CompositeServiceHelper.processCreateOrderResponse();
  }
}
