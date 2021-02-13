package demo.op.composite.order.collector.comp.v2.stream;

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
import demo.op.composite.order.collector.comp.v2.IOrderCollectorCompV2CompositeService;

import brave.Tracer;

@Component
public class OrderCollectorCompV2CompositeUpdateOrderStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.updateorder.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IOrderCollectorCompV2CompositeService orderCollectorCompV2CompositeService;

  public OrderCollectorCompV2CompositeUpdateOrderStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IOrderCollectorCompV2CompositeService orderCollectorCompV2CompositeService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.orderCollectorCompV2CompositeService = orderCollectorCompV2CompositeService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {
    com.abcd.oop.model.Order source =
        jsonUtils.convertFromJson(getPayload(), com.abcd.oop.model.Order.class);
    getServiceRequestContext().setBody(source);
    orderCollectorCompV2CompositeService.updateOrder(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
