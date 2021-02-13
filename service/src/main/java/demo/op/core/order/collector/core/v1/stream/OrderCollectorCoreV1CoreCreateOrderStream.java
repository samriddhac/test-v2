package demo.op.core.order.collector.core.v1.stream;

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
import demo.op.core.order.collector.core.v1.service.IOrderCollectorCoreV1CoreService;

import com.macys.uop.model.Order;
import brave.Tracer;

@Component
public class OrderCollectorCoreV1CoreCreateOrderStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.createorder.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IOrderCollectorCoreV1CoreService orderCollectorCoreV1CoreService;

  public OrderCollectorCoreV1CoreCreateOrderStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IOrderCollectorCoreV1CoreService orderCollectorCoreV1CoreService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.orderCollectorCoreV1CoreService = orderCollectorCoreV1CoreService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {
    Order source = jsonUtils.convertFromJson(getPayload(), Order.class);
    getServiceRequestContext().setBody(source);
    orderCollectorCoreV1CoreService.createOrder(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
