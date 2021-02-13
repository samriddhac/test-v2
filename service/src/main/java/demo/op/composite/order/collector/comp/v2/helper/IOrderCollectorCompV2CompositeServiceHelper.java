package demo.op.composite.order.collector.comp.v2.helper;

import java.util.List;

public interface IOrderCollectorCompV2CompositeServiceHelper {

  public void processCollectOrderRequest();

  public com.abcd.uop.model.Order processCollectOrderResponse();

  public void processUpdateOrderRequest();

  public com.abcd.oop.model.Order processUpdateOrderResponse();
}
