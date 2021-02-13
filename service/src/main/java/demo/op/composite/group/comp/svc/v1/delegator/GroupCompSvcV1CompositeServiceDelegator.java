package demo.op.composite.group.comp.svc.v1.delegator;

import com.abcd.uop.model.Order;
import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.future.FutureUtils;
import demo.op.composite.group.comp.svc.v1.IGroupCompSvcV1CompositeService;
import demo.op.composite.group.comp.svc.v1.helper.IGroupCompSvcV1CompositeServiceHelper;
import demo.op.composite.group.comp.svc.v1.helper.IGroupCoreSvcV1CoreServiceHelper;
import java.lang.Override;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupCompSvcV1CompositeServiceDelegator
    implements IGroupCompSvcV1CompositeService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IGroupCompSvcV1CompositeServiceHelper groupCompSvcV1CompositeServiceHelper;

  private final IGroupCoreSvcV1CoreServiceHelper groupCoreSvcV1CoreServiceHelper;

  @Override
  public List<List<Order>> groupLogicalShipments(List<Order> lineItemArray) {
    groupCompSvcV1CompositeServiceHelper.processGroupLogicalShipmentsRequest();
    if (isServiceCallEnabled("9bd96134-46af-4761-b3cc-8432abe14e58")) {
      groupCoreSvcV1CoreServiceHelper.groupLogicalShipments("9bd96134-46af-4761-b3cc-8432abe14e58");
    }
    return groupCompSvcV1CompositeServiceHelper.processGroupLogicalShipmentsResponse();
  }
}
