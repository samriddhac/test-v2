package demo.op.composite.order.primitive.comp.v2.stream;

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
import demo.op.composite.order.primitive.comp.v2.IOrderPrimitiveCompV2CompositeService;

import brave.Tracer;

@Component
public class OrderPrimitiveCompV2CompositeGetOrderIdForCustomerOrderIdOrReservationIdStream
    extends AbstractStreamSubscriber implements ServiceContextUtil {

  @Value("${topic.subscription.getorderidforcustomerorderidorreservationid.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IOrderPrimitiveCompV2CompositeService orderPrimitiveCompV2CompositeService;

  public OrderPrimitiveCompV2CompositeGetOrderIdForCustomerOrderIdOrReservationIdStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IOrderPrimitiveCompV2CompositeService orderPrimitiveCompV2CompositeService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.orderPrimitiveCompV2CompositeService = orderPrimitiveCompV2CompositeService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {}

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
