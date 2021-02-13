package demo.op.composite.order.collector.comp.v2.helper;

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
public abstract class AbstractOrderCollectorCoreV2CoreServiceHelper
    implements IOrderCollectorCoreV2CoreServiceHelper, ServiceExecutionContextUtil {

  private final RestTemplate restTemplateOrderCollectorCoreV2CoreService;
  private final Logger loggerOrderCollectorCoreV2CoreService;

  @Value("${order-collector-service.base_uri}")
  private String baseUriOrderCollectorCoreV2CoreService;

  @Value("${order-collector-service.service_name}")
  private String serviceNameOrderCollectorCoreV2CoreService;

  @Value("${order-collector-service.service_version}")
  private String serviceVersionOrderCollectorCoreV2CoreService;

  @Override
  @CircuitBreaker(name = "collectOrder-cb", fallbackMethod = "processCollectOrderFallback")
  @Bulkhead(name = "collectOrder-bh")
  public com.abcd.uop.model.Order collectOrder(String serviceCallId) {
    Assert.isTrue(!StringUtils.isAllBlank(serviceCallId), "serviceCallId cannot be null or blank");
    ServiceRequestContext serviceRequestContextOrderCollectorCoreV2CoreService = null;
    ServiceResponseContext serviceResponseContextOrderCollectorCoreV2CoreService = null;
    ResponseEntity<com.abcd.uop.model.Order> responseEntityOrderCollectorCoreV2CoreService = null;
    ServiceData serviceDataOrderCollectorCoreV2CoreService = null;
    serviceRequestContextOrderCollectorCoreV2CoreService =
        processCollectOrderRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextOrderCollectorCoreV2CoreService);
    serviceRequestContextOrderCollectorCoreV2CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriOrderCollectorCoreV2CoreService + "/orders/collect"))
            .queryParams(serviceRequestContextOrderCollectorCoreV2CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextOrderCollectorCoreV2CoreService.getPathParams())
            .toUriString());
    serviceRequestContextOrderCollectorCoreV2CoreService.setMethod(HttpMethod.POST.name());
    serviceDataOrderCollectorCoreV2CoreService = new ServiceData();
    serviceDataOrderCollectorCoreV2CoreService.setName(serviceNameOrderCollectorCoreV2CoreService);
    serviceDataOrderCollectorCoreV2CoreService.setVersion(
        serviceVersionOrderCollectorCoreV2CoreService);
    serviceDataOrderCollectorCoreV2CoreService.setOperation(HttpMethod.POST.toString());
    serviceDataOrderCollectorCoreV2CoreService.setServiceRequestContext(
        serviceRequestContextOrderCollectorCoreV2CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderCollectorCoreV2CoreService);
    loggerOrderCollectorCoreV2CoreService.logRestClientRequest(
        HttpMethod.POST.name(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventType(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventMessage(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getBody());

    responseEntityOrderCollectorCoreV2CoreService =
        restTemplateOrderCollectorCoreV2CoreService.exchange(
            serviceRequestContextOrderCollectorCoreV2CoreService.getUrl(),
            HttpMethod.POST,
            new HttpEntity<>(
                serviceRequestContextOrderCollectorCoreV2CoreService.getBody(),
                serviceRequestContextOrderCollectorCoreV2CoreService.getHeaders()),
            com.abcd.uop.model.Order.class);

    loggerOrderCollectorCoreV2CoreService.logRestClientResponse(
        HttpMethod.POST.name(),
        String.valueOf(responseEntityOrderCollectorCoreV2CoreService.getStatusCode().value()),
        responseEntityOrderCollectorCoreV2CoreService.getStatusCode().name(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventType(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventMessage(),
        responseEntityOrderCollectorCoreV2CoreService.getBody());
    serviceResponseContextOrderCollectorCoreV2CoreService = new ServiceResponseContext();
    serviceResponseContextOrderCollectorCoreV2CoreService.setBody(
        responseEntityOrderCollectorCoreV2CoreService.getBody());
    serviceResponseContextOrderCollectorCoreV2CoreService.setHeaders(
        responseEntityOrderCollectorCoreV2CoreService.getHeaders());
    serviceDataOrderCollectorCoreV2CoreService.setServiceResponseContext(
        serviceResponseContextOrderCollectorCoreV2CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderCollectorCoreV2CoreService);
    return processCollectOrderResponse(serviceCallId);
  }

  @Override
  @CircuitBreaker(name = "updateOrder-cb", fallbackMethod = "processUpdateOrderFallback")
  @Bulkhead(name = "updateOrder-bh")
  public com.abcd.oop.model.Order updateOrder(String serviceCallId) {
    Assert.isTrue(!StringUtils.isAllBlank(serviceCallId), "serviceCallId cannot be null or blank");
    ServiceRequestContext serviceRequestContextOrderCollectorCoreV2CoreService = null;
    ServiceResponseContext serviceResponseContextOrderCollectorCoreV2CoreService = null;
    ResponseEntity<com.abcd.oop.model.Order> responseEntityOrderCollectorCoreV2CoreService = null;
    ServiceData serviceDataOrderCollectorCoreV2CoreService = null;
    serviceRequestContextOrderCollectorCoreV2CoreService = processUpdateOrderRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextOrderCollectorCoreV2CoreService);
    serviceRequestContextOrderCollectorCoreV2CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriOrderCollectorCoreV2CoreService + "/orders/collect"))
            .queryParams(serviceRequestContextOrderCollectorCoreV2CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextOrderCollectorCoreV2CoreService.getPathParams())
            .toUriString());
    serviceRequestContextOrderCollectorCoreV2CoreService.setMethod(HttpMethod.PUT.name());
    serviceDataOrderCollectorCoreV2CoreService = new ServiceData();
    serviceDataOrderCollectorCoreV2CoreService.setName(serviceNameOrderCollectorCoreV2CoreService);
    serviceDataOrderCollectorCoreV2CoreService.setVersion(
        serviceVersionOrderCollectorCoreV2CoreService);
    serviceDataOrderCollectorCoreV2CoreService.setOperation(HttpMethod.PUT.toString());
    serviceDataOrderCollectorCoreV2CoreService.setServiceRequestContext(
        serviceRequestContextOrderCollectorCoreV2CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderCollectorCoreV2CoreService);
    loggerOrderCollectorCoreV2CoreService.logRestClientRequest(
        HttpMethod.PUT.name(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventType(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventMessage(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getBody());

    responseEntityOrderCollectorCoreV2CoreService =
        restTemplateOrderCollectorCoreV2CoreService.exchange(
            serviceRequestContextOrderCollectorCoreV2CoreService.getUrl(),
            HttpMethod.PUT,
            new HttpEntity<>(
                serviceRequestContextOrderCollectorCoreV2CoreService.getBody(),
                serviceRequestContextOrderCollectorCoreV2CoreService.getHeaders()),
            com.abcd.oop.model.Order.class);

    loggerOrderCollectorCoreV2CoreService.logRestClientResponse(
        HttpMethod.PUT.name(),
        String.valueOf(responseEntityOrderCollectorCoreV2CoreService.getStatusCode().value()),
        responseEntityOrderCollectorCoreV2CoreService.getStatusCode().name(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventType(),
        serviceRequestContextOrderCollectorCoreV2CoreService.getEventMessage(),
        responseEntityOrderCollectorCoreV2CoreService.getBody());
    serviceResponseContextOrderCollectorCoreV2CoreService = new ServiceResponseContext();
    serviceResponseContextOrderCollectorCoreV2CoreService.setBody(
        responseEntityOrderCollectorCoreV2CoreService.getBody());
    serviceResponseContextOrderCollectorCoreV2CoreService.setHeaders(
        responseEntityOrderCollectorCoreV2CoreService.getHeaders());
    serviceDataOrderCollectorCoreV2CoreService.setServiceResponseContext(
        serviceResponseContextOrderCollectorCoreV2CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderCollectorCoreV2CoreService);
    return processUpdateOrderResponse(serviceCallId);
  }
}
