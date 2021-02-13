package demo.op.composite.group.comp.svc.v1.helper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import demo.op.composite.group.comp.svc.v1.helper.IGroupCompSvcV1CompositeServiceHelper;
import com.abcd.uop.model.Order;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GroupCompSvcV1CompositeServiceHelperImpl
    implements IGroupCompSvcV1CompositeServiceHelper, ServiceExecutionContextUtil {

  @Override
  public void processGroupLogicalShipmentsRequest() {
    // TODO: your code goes here...
    enableServiceCall("9bd96134-46af-4761-b3cc-8432abe14e58");
  }

  @Override
  public List<List<Order>> processGroupLogicalShipmentsResponse() {
    // TODO: your code goes here...
    return Collections.emptyList();
  }
}
