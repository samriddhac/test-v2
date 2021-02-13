package demo.op.composite.order.comp.v1.helper;

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
import com.macys.uop.model.Order;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractOrderCoreV1CoreServiceHelper
    implements IOrderCoreV1CoreServiceHelper, ServiceExecutionContextUtil {

  private final RestTemplate restTemplateOrderCoreV1CoreService;
  private final Logger loggerOrderCoreV1CoreService;

  @Value("${order-service.base_uri}")
  private String baseUriOrderCoreV1CoreService;

  @Value("${order-service.service_name}")
  private String serviceNameOrderCoreV1CoreService;

  @Value("${order-service.service_version}")
  private String serviceVersionOrderCoreV1CoreService;

  @Override
  @CircuitBreaker(name = "createOrder-cb", fallbackMethod = "processCreateOrderFallback")
  @Bulkhead(name = "createOrder-bh")
  public Order createOrder(String serviceCallId) {
    Assert.isTrue(!StringUtils.isAllBlank(serviceCallId), "serviceCallId cannot be null or blank");
    ServiceRequestContext serviceRequestContextOrderCoreV1CoreService = null;
    ServiceResponseContext serviceResponseContextOrderCoreV1CoreService = null;
    ResponseEntity<Order> responseEntityOrderCoreV1CoreService = null;
    ServiceData serviceDataOrderCoreV1CoreService = null;
    serviceRequestContextOrderCoreV1CoreService = processCreateOrderRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextOrderCoreV1CoreService);
    serviceRequestContextOrderCoreV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl((baseUriOrderCoreV1CoreService + "/orders"))
            .queryParams(serviceRequestContextOrderCoreV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextOrderCoreV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextOrderCoreV1CoreService.setMethod(HttpMethod.POST.name());
    serviceDataOrderCoreV1CoreService = new ServiceData();
    serviceDataOrderCoreV1CoreService.setName(serviceNameOrderCoreV1CoreService);
    serviceDataOrderCoreV1CoreService.setVersion(serviceVersionOrderCoreV1CoreService);
    serviceDataOrderCoreV1CoreService.setOperation(HttpMethod.POST.toString());
    serviceDataOrderCoreV1CoreService.setServiceRequestContext(
        serviceRequestContextOrderCoreV1CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderCoreV1CoreService);
    loggerOrderCoreV1CoreService.logRestClientRequest(
        HttpMethod.POST.name(),
        serviceRequestContextOrderCoreV1CoreService.getEventType(),
        serviceRequestContextOrderCoreV1CoreService.getEventMessage(),
        serviceRequestContextOrderCoreV1CoreService.getBody());

    responseEntityOrderCoreV1CoreService =
        restTemplateOrderCoreV1CoreService.exchange(
            serviceRequestContextOrderCoreV1CoreService.getUrl(),
            HttpMethod.POST,
            new HttpEntity<>(
                serviceRequestContextOrderCoreV1CoreService.getBody(),
                serviceRequestContextOrderCoreV1CoreService.getHeaders()),
            Order.class);

    loggerOrderCoreV1CoreService.logRestClientResponse(
        HttpMethod.POST.name(),
        String.valueOf(responseEntityOrderCoreV1CoreService.getStatusCode().value()),
        responseEntityOrderCoreV1CoreService.getStatusCode().name(),
        serviceRequestContextOrderCoreV1CoreService.getEventType(),
        serviceRequestContextOrderCoreV1CoreService.getEventMessage(),
        responseEntityOrderCoreV1CoreService.getBody());
    serviceResponseContextOrderCoreV1CoreService = new ServiceResponseContext();
    serviceResponseContextOrderCoreV1CoreService.setBody(
        responseEntityOrderCoreV1CoreService.getBody());
    serviceResponseContextOrderCoreV1CoreService.setHeaders(
        responseEntityOrderCoreV1CoreService.getHeaders());
    serviceDataOrderCoreV1CoreService.setServiceResponseContext(
        serviceResponseContextOrderCoreV1CoreService);
    setServiceCallResult(serviceCallId, serviceDataOrderCoreV1CoreService);
    return processCreateOrderResponse(serviceCallId);
  }
}
