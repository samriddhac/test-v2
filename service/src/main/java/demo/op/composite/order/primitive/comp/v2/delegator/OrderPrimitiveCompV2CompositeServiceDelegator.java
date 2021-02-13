package demo.op.composite.order.primitive.comp.v2.delegator;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.future.FutureUtils;
import demo.op.composite.order.primitive.comp.v2.IOrderPrimitiveCompV2CompositeService;
import demo.op.composite.order.primitive.comp.v2.helper.IOrderPrimitiveCompV2CompositeServiceHelper;
import demo.op.composite.order.primitive.comp.v2.helper.IOrderPrimitiveCoreV1CoreServiceHelper;
import java.lang.Double;
import java.lang.Override;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPrimitiveCompV2CompositeServiceDelegator
    implements IOrderPrimitiveCompV2CompositeService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IOrderPrimitiveCompV2CompositeServiceHelper
      orderPrimitiveCompV2CompositeServiceHelper;

  private final IOrderPrimitiveCoreV1CoreServiceHelper orderPrimitiveCoreV1CoreServiceHelper;

  @Override
  public Double getOrderIdForCustomerOrderIdOrReservationId() {
    orderPrimitiveCompV2CompositeServiceHelper
        .processGetOrderIdForCustomerOrderIdOrReservationIdRequest();
    if (isServiceCallEnabled("aeddb5c7-d6e8-4d19-9832-237e6df2fe28")) {
      orderPrimitiveCoreV1CoreServiceHelper.getOrderIdForCustomerOrderIdOrReservationId(
          "aeddb5c7-d6e8-4d19-9832-237e6df2fe28");
    }
    return orderPrimitiveCompV2CompositeServiceHelper
        .processGetOrderIdForCustomerOrderIdOrReservationIdResponse();
  }
}
