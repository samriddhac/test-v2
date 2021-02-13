package demo.op.composite.group.comp.svc.v1.helper;

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
import com.abcd.uop.model.Order;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractGroupCoreSvcV1CoreServiceHelper
    implements IGroupCoreSvcV1CoreServiceHelper, ServiceExecutionContextUtil {

  private final RestTemplate restTemplateGroupCoreSvcV1CoreService;
  private final Logger loggerGroupCoreSvcV1CoreService;

  @Value("${Releasegroup-Service.base_uri}")
  private String baseUriGroupCoreSvcV1CoreService;

  @Value("${Releasegroup-Service.service_name}")
  private String serviceNameGroupCoreSvcV1CoreService;

  @Value("${Releasegroup-Service.service_version}")
  private String serviceVersionGroupCoreSvcV1CoreService;

  @Override
  @CircuitBreaker(
      name = "groupLogicalShipments-cb",
      fallbackMethod = "processGroupLogicalShipmentsFallback")
  @Bulkhead(name = "groupLogicalShipments-bh")
  public List<List<Order>> groupLogicalShipments(String serviceCallId) {
    Assert.isTrue(!StringUtils.isAllBlank(serviceCallId), "serviceCallId cannot be null or blank");
    ServiceRequestContext serviceRequestContextGroupCoreSvcV1CoreService = null;
    ServiceResponseContext serviceResponseContextGroupCoreSvcV1CoreService = null;
    ResponseEntity<Order[][]> responseEntityGroupCoreSvcV1CoreService = null;
    ServiceData serviceDataGroupCoreSvcV1CoreService = null;
    serviceRequestContextGroupCoreSvcV1CoreService =
        processGroupLogicalShipmentsRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextGroupCoreSvcV1CoreService);
    serviceRequestContextGroupCoreSvcV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriGroupCoreSvcV1CoreService + "/op/v1/order/release/logicalshipments"))
            .queryParams(serviceRequestContextGroupCoreSvcV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextGroupCoreSvcV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextGroupCoreSvcV1CoreService.setMethod(HttpMethod.POST.name());
    serviceDataGroupCoreSvcV1CoreService = new ServiceData();
    serviceDataGroupCoreSvcV1CoreService.setName(serviceNameGroupCoreSvcV1CoreService);
    serviceDataGroupCoreSvcV1CoreService.setVersion(serviceVersionGroupCoreSvcV1CoreService);
    serviceDataGroupCoreSvcV1CoreService.setOperation(HttpMethod.POST.toString());
    serviceDataGroupCoreSvcV1CoreService.setServiceRequestContext(
        serviceRequestContextGroupCoreSvcV1CoreService);
    setServiceCallResult(serviceCallId, serviceDataGroupCoreSvcV1CoreService);
    loggerGroupCoreSvcV1CoreService.logRestClientRequest(
        HttpMethod.POST.name(),
        serviceRequestContextGroupCoreSvcV1CoreService.getEventType(),
        serviceRequestContextGroupCoreSvcV1CoreService.getEventMessage(),
        serviceRequestContextGroupCoreSvcV1CoreService.getBody());

    responseEntityGroupCoreSvcV1CoreService =
        restTemplateGroupCoreSvcV1CoreService.exchange(
            serviceRequestContextGroupCoreSvcV1CoreService.getUrl(),
            HttpMethod.POST,
            new HttpEntity<>(
                serviceRequestContextGroupCoreSvcV1CoreService.getBody(),
                serviceRequestContextGroupCoreSvcV1CoreService.getHeaders()),
            Order[][].class);

    loggerGroupCoreSvcV1CoreService.logRestClientResponse(
        HttpMethod.POST.name(),
        String.valueOf(responseEntityGroupCoreSvcV1CoreService.getStatusCode().value()),
        responseEntityGroupCoreSvcV1CoreService.getStatusCode().name(),
        serviceRequestContextGroupCoreSvcV1CoreService.getEventType(),
        serviceRequestContextGroupCoreSvcV1CoreService.getEventMessage(),
        responseEntityGroupCoreSvcV1CoreService.getBody());
    serviceResponseContextGroupCoreSvcV1CoreService = new ServiceResponseContext();
    serviceResponseContextGroupCoreSvcV1CoreService.setBody(
        responseEntityGroupCoreSvcV1CoreService.getBody());
    serviceResponseContextGroupCoreSvcV1CoreService.setHeaders(
        responseEntityGroupCoreSvcV1CoreService.getHeaders());
    serviceDataGroupCoreSvcV1CoreService.setServiceResponseContext(
        serviceResponseContextGroupCoreSvcV1CoreService);
    setServiceCallResult(serviceCallId, serviceDataGroupCoreSvcV1CoreService);
    return processGroupLogicalShipmentsResponse(serviceCallId);
  }
}
