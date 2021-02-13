package demo.op.composite.airport.comp.svc.v1.stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

import com.google.pubsub.v1.PubsubMessage;
import com.macys.mst.order.foundation.core.utils.execution.ServiceContextUtil;
import com.macys.mst.order.foundation.core.utils.json.JsonUtils;
import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.macys.mst.order.foundation.core.utils.message.validation.MessageValidator;
import com.macys.mst.order.foundation.core.utils.msg.subscriber.AbstractStreamSubscriber;
import demo.op.composite.airport.comp.svc.v1.IAirportCompSvcV1CompositeService;

import demo.cosmos.core.airport.model.Airport;
import demo.cosmos.core.airport.model.Airport;
import brave.Tracer;

@Component
public class AirportCompSvcV1CompositeDeleteAirportStream extends AbstractStreamSubscriber
    implements ServiceContextUtil {

  @Value("${topic.subscription.deleteairport.name}")
  private String subscriptionName;

  private final JsonUtils jsonUtils;

  private final IAirportCompSvcV1CompositeService airportCompSvcV1CompositeService;

  public AirportCompSvcV1CompositeDeleteAirportStream(
      PubSubTemplate pubSubTemplate,
      MessageValidator messageValidator,
      JsonUtils jsonUtils,
      Logger logger,
      Tracer tracer,
      IAirportCompSvcV1CompositeService airportCompSvcV1CompositeService) {
    super(pubSubTemplate, messageValidator, logger, tracer);
    this.airportCompSvcV1CompositeService = airportCompSvcV1CompositeService;
    this.jsonUtils = jsonUtils;
  }

  @Override
  protected void invokeService(PubsubMessage message) {
    Airport source = jsonUtils.convertFromJson(getPayload(), Airport.class);
    getServiceRequestContext().setBody(source);
    airportCompSvcV1CompositeService.deleteAirport(source);
  }

  @Override
  protected String getTopicSubscription() {
    return subscriptionName;
  }
}
