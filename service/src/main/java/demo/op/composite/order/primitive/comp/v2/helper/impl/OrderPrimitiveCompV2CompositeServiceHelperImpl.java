package demo.op.composite.order.primitive.comp.v2.helper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import demo.op.composite.order.primitive.comp.v2.helper.IOrderPrimitiveCompV2CompositeServiceHelper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderPrimitiveCompV2CompositeServiceHelperImpl
    implements IOrderPrimitiveCompV2CompositeServiceHelper, ServiceExecutionContextUtil {

  @Override
  public void processGetOrderIdForCustomerOrderIdOrReservationIdRequest() {
    // TODO: your code goes here...
    enableServiceCall("aeddb5c7-d6e8-4d19-9832-237e6df2fe28");
  }

  @Override
  public Double processGetOrderIdForCustomerOrderIdOrReservationIdResponse() {
    // TODO: your code goes here...
    return null;
  }
}
