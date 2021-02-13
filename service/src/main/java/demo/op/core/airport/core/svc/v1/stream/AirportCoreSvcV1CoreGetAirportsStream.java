package demo.op.core.airport.core.svc.v1.stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

import com.google.pubsub.v1.PubsubMessage;
import com.macys.mst.order.foundation.core.utils.execution.ServiceContextUtil;
import com.macys.mst.order.foundation.core.utils.json.JsonUtils;
import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.message.validation.MessageValidator;
import com.macys.mst.order.foundation.core.utils.msg.subscriber.AbstractStreamSubscriber;
import demo.op.core.airport.core.svc.v1.service.IAirportCoreSvcV1CoreService;

import demo.cosmos.core.airport.model.Airport;
import brave.Tracer;

@Component
public class AirportCoreSvcV1CoreGetAirportsStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.getairports.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IAirportCoreSvcV1CoreService airportCoreSvcV1CoreService;

  public AirportCoreSvcV1CoreGetAirportsStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IAirportCoreSvcV1CoreService airportCoreSvcV1CoreService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.airportCoreSvcV1CoreService = airportCoreSvcV1CoreService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {}

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
