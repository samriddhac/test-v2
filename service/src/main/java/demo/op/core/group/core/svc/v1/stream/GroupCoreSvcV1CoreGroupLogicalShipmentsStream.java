package demo.op.core.group.core.svc.v1.stream;

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
import demo.op.core.group.core.svc.v1.service.IGroupCoreSvcV1CoreService;

import com.abcd.uop.model.Order;
import brave.Tracer;

@Component
public class GroupCoreSvcV1CoreGroupLogicalShipmentsStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.grouplogicalshipments.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IGroupCoreSvcV1CoreService groupCoreSvcV1CoreService;

  public GroupCoreSvcV1CoreGroupLogicalShipmentsStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IGroupCoreSvcV1CoreService groupCoreSvcV1CoreService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.groupCoreSvcV1CoreService = groupCoreSvcV1CoreService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {
    List<Order> source = jsonUtils.convertFromJson(getPayload(), Order.class);
    getServiceRequestContext().setBody(source);
    groupCoreSvcV1CoreService.groupLogicalShipments(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
