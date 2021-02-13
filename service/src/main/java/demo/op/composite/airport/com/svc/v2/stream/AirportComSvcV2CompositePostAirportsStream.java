package demo.op.composite.airport.com.svc.v2.stream;

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
import demo.op.composite.airport.com.svc.v2.IAirportComSvcV2CompositeService;

import demo.cosmos.core.airport.model.Airport;
import brave.Tracer;

@Component
public class AirportComSvcV2CompositePostAirportsStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.postairports.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IAirportComSvcV2CompositeService airportComSvcV2CompositeService;

  public AirportComSvcV2CompositePostAirportsStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IAirportComSvcV2CompositeService airportComSvcV2CompositeService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.airportComSvcV2CompositeService = airportComSvcV2CompositeService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {
    Airport source = jsonUtils.convertFromJson(getPayload(), Airport.class);
    getServiceRequestContext().setBody(source);
    airportComSvcV2CompositeService.postAirports(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
