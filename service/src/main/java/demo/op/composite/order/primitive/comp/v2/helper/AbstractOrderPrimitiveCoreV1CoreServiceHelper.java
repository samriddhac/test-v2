package demo.op.composite.order.primitive.comp.v2.helper;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import com.macys.mst.order.foundation.core.utils.execution.ServiceData;
import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import com.macys.mst.order.foundation.core.utils.execution.ServiceResponseContext;
import com.macys.mst.order.foundation.core.utils.logging.Logger;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractOrderPrimitiveCoreV1CoreServiceHelper
    implements IOrderPrimitiveCoreV1CoreServiceHelper, ServiceExecutionContextUtil {

  private final RestTemplate restTemplateOrderPrimitiveCoreV1CoreService;
  private final Logger loggerOrderPrimitiveCoreV1CoreService;

  @Value("${order-core-service.base_uri}")
  private String baseUriOrderPrimitiveCoreV1CoreService;

  @Value("${order-core-service.service_name}")
  private String serviceNameOrderPrimitiveCoreV1CoreService;

  @Value("${order-core-service.service_version}")
  private String serviceVersionOrderPrimitiveCoreV1CoreService;

  @Override
  @CircuitBreaker(
      name = "getOrderIdForCustomerOrderIdOrReservationId-cb",
      fallbackMethod = "processGetOrderIdForCustomerOrderIdOrReservationIdFallback")
  @Bulkhead(name = "getOrderIdForCustomerOrderIdOrReservationId-bh")
  public Double getOrderIdForCustomerOrderIdOrReservationId(String serviceCallId) {
    Assert.isTrue(!StringUtils.isAllBlank(serviceCallId), "serviceCallId cannot be null or blank");
    ServiceRequestContext serviceRequestContextOrderPrimitiveCoreV1CoreService = null;
    ServiceResponseContext serviceResponseContextOrderPrimitiveCoreV1CoreService = null;
    ResponseEntity<Double> responseEntityOrderPrimitiveCoreV1CoreService = null;
    ServiceData serviceDataOrderPrimitiveCoreV1CoreService = null;
    serviceRequestContextOrderPrimitiveCoreV1CoreService =
        processGetOrderIdForCustomerOrderIdOrReservationIdRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextOrderPrimitiveCoreV1CoreService);
    serviceRequestContextOrderPrimitiveCoreV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriOrderPrimitiveCoreV1CoreService + "/op/v1/order/orderid"))
            .queryParams(serviceRequestContextOrderPrimitiveCoreV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextOrderPrimitiveCoreV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextOrderPrimitiveCoreV1CoreService.setMethod(HttpMethod.GET.name());
    serviceDataOrderPrimitiveCoreV1CoreService = new ServiceData();
    serviceDataOrderPrimitiveCoreV1CoreService.setName(serviceNameOrderPrimitiveCoreV1CoreService);
    serviceDataOrderPrimitiveCoreV1CoreService.setVersion(
        serviceVersionOrderPrimitiveCoreV1CoreService);
    serviceDataOrderPrimitiveCoreV1CoreService.setOperation(HttpMethod.GET.toString());
    serviceDataOrderPrimitiveCoreV1CoreService.setServiceRequestContext(
        serviceRequestContextOrderPrimitiveCoreV1CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderPrimitiveCoreV1CoreService);
    loggerOrderPrimitiveCoreV1CoreService.logRestClientRequest(
        HttpMethod.GET.name(),
        serviceRequestContextOrderPrimitiveCoreV1CoreService.getEventType(),
        serviceRequestContextOrderPrimitiveCoreV1CoreService.getEventMessage(),
        null);

    responseEntityOrderPrimitiveCoreV1CoreService =
        restTemplateOrderPrimitiveCoreV1CoreService.exchange(
            serviceRequestContextOrderPrimitiveCoreV1CoreService.getUrl(),
            HttpMethod.GET,
            new HttpEntity<>(serviceRequestContextOrderPrimitiveCoreV1CoreService.getHeaders()),
            Double.class);

    loggerOrderPrimitiveCoreV1CoreService.logRestClientResponse(
        HttpMethod.GET.name(),
        String.valueOf(responseEntityOrderPrimitiveCoreV1CoreService.getStatusCode().value()),
        responseEntityOrderPrimitiveCoreV1CoreService.getStatusCode().name(),
        serviceRequestContextOrderPrimitiveCoreV1CoreService.getEventType(),
        serviceRequestContextOrderPrimitiveCoreV1CoreService.getEventMessage(),
        responseEntityOrderPrimitiveCoreV1CoreService.getBody());
    serviceResponseContextOrderPrimitiveCoreV1CoreService = new ServiceResponseContext();
    serviceResponseContextOrderPrimitiveCoreV1CoreService.setBody(
        responseEntityOrderPrimitiveCoreV1CoreService.getBody());
    serviceResponseContextOrderPrimitiveCoreV1CoreService.setHeaders(
        responseEntityOrderPrimitiveCoreV1CoreService.getHeaders());
    serviceDataOrderPrimitiveCoreV1CoreService.setServiceResponseContext(
        serviceResponseContextOrderPrimitiveCoreV1CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderPrimitiveCoreV1CoreService);
    return processGetOrderIdForCustomerOrderIdOrReservationIdResponse(serviceCallId);
  }
}
