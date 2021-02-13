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
public class OrderCollectorCompV2CompositeCollectOrderStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.collectorder.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IOrderCollectorCompV2CompositeService orderCollectorCompV2CompositeService;

  public OrderCollectorCompV2CompositeCollectOrderStream(
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
    com.abcd.uop.model.Order source =
        jsonUtils.convertFromJson(getPayload(), com.abcd.uop.model.Order.class);
    getServiceRequestContext().setBody(source);
    orderCollectorCompV2CompositeService.collectOrder(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
