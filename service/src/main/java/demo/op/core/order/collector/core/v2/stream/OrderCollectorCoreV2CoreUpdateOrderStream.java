package demo.op.core.order.collector.core.v2.stream;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

import com.google.pubsub.v1.PubsubMessage;
import com.macys.mst.order.foundation.core.utils.execution.ServiceContextUtil;
import com.macys.mst.order.foundation.core.utils.json.JsonUtils;
import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.message.validation.MessageValidator;
import com.macys.mst.order.foundation.core.utils.msg.subscriber.AbstractStreamSubscriber;
import demo.op.core.order.collector.core.v2.service.IOrderCollectorCoreV2CoreService;

import brave.Tracer;

@Component
public class OrderCollectorCoreV2CoreUpdateOrderStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.updateorder.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IOrderCollectorCoreV2CoreService orderCollectorCoreV2CoreService;

  public OrderCollectorCoreV2CoreUpdateOrderStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IOrderCollectorCoreV2CoreService orderCollectorCoreV2CoreService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.orderCollectorCoreV2CoreService = orderCollectorCoreV2CoreService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {
    com.abcd.oop.model.Order source =
        jsonUtils.convertFromJson(getPayload(), com.abcd.oop.model.Order.class);
    getServiceRequestContext().setBody(source);
    orderCollectorCoreV2CoreService.updateOrder(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
