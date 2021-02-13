package demo.op.composite.airport.comp.svc.v1.helper;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;

import com.macys.mst.order.foundation.core.utils.execution.ServiceData;
import com.macys.mst.order.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import com.macys.mst.order.foundation.core.utils.execution.ServiceResponseContext;
import com.macys.mst.order.foundation.core.utils.logging.Logger;
import demo.cosmos.core.airport.model.Airport;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractAirportCoreSvcV1CoreServiceHelper
    implements IAirportCoreSvcV1CoreServiceHelper, ServiceExecutionContextUtil {

  private final RestTemplate restTemplateAirportCoreSvcV1CoreService;
  private final Logger loggerAirportCoreSvcV1CoreService;

  @Value("${airport-service.base_uri}")
  private String baseUriAirportCoreSvcV1CoreService;

  @Value("${airport-service.service_name}")
  private String serviceNameAirportCoreSvcV1CoreService;

  @Value("${airport-service.service_version}")
  private String serviceVersionAirportCoreSvcV1CoreService;

  @Override
  @CircuitBreaker(name = "getAirports-cb", fallbackMethod = "processGetAirportsFallback")
  @Bulkhead(name = "getAirports-bh")
  public List<Airport> getAirports(String serviceCallId) {
    ServiceRequestContext serviceRequestContextAirportCoreSvcV1CoreService = null;
    ServiceResponseContext serviceResponseContextAirportCoreSvcV1CoreService = null;
    ResponseEntity<Airport[]> responseEntityAirportCoreSvcV1CoreService = null;
    ServiceData serviceDataAirportCoreSvcV1CoreService = null;
    serviceRequestContextAirportCoreSvcV1CoreService = processGetAirportsRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextAirportCoreSvcV1CoreService);
    serviceRequestContextAirportCoreSvcV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl((baseUriAirportCoreSvcV1CoreService + "/airports"))
            .queryParams(serviceRequestContextAirportCoreSvcV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextAirportCoreSvcV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextAirportCoreSvcV1CoreService.setMethod(HttpMethod.GET.name());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService = new ServiceData();
      serviceDataAirportCoreSvcV1CoreService.setName(serviceNameAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setVersion(serviceVersionAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setOperation(HttpMethod.GET.toString());
      serviceDataAirportCoreSvcV1CoreService.setServiceRequestContext(
          serviceRequestContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    loggerAirportCoreSvcV1CoreService.logRestClientRequest(
        HttpMethod.GET.name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        null);

    responseEntityAirportCoreSvcV1CoreService =
        restTemplateAirportCoreSvcV1CoreService.exchange(
            serviceRequestContextAirportCoreSvcV1CoreService.getUrl(),
            HttpMethod.GET,
            new HttpEntity<>(serviceRequestContextAirportCoreSvcV1CoreService.getHeaders()),
            Airport[].class);

    loggerAirportCoreSvcV1CoreService.logRestClientResponse(
        HttpMethod.GET.name(),
        String.valueOf(responseEntityAirportCoreSvcV1CoreService.getStatusCode().value()),
        responseEntityAirportCoreSvcV1CoreService.getStatusCode().name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService = new ServiceResponseContext();
    serviceResponseContextAirportCoreSvcV1CoreService.setBody(
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService.setHeaders(
        responseEntityAirportCoreSvcV1CoreService.getHeaders());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService.setServiceResponseContext(
          serviceResponseContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    return processGetAirportsResponse(serviceCallId);
  }

  @Override
  @CircuitBreaker(name = "postAirports-cb", fallbackMethod = "processPostAirportsFallback")
  @Bulkhead(name = "postAirports-bh")
  public Object postAirports(String serviceCallId) {
    ServiceRequestContext serviceRequestContextAirportCoreSvcV1CoreService = null;
    ServiceResponseContext serviceResponseContextAirportCoreSvcV1CoreService = null;
    ResponseEntity<Object> responseEntityAirportCoreSvcV1CoreService = null;
    ServiceData serviceDataAirportCoreSvcV1CoreService = null;
    serviceRequestContextAirportCoreSvcV1CoreService = processPostAirportsRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextAirportCoreSvcV1CoreService);
    serviceRequestContextAirportCoreSvcV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl((baseUriAirportCoreSvcV1CoreService + "/airports"))
            .queryParams(serviceRequestContextAirportCoreSvcV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextAirportCoreSvcV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextAirportCoreSvcV1CoreService.setMethod(HttpMethod.POST.name());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService = new ServiceData();
      serviceDataAirportCoreSvcV1CoreService.setName(serviceNameAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setVersion(serviceVersionAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setOperation(HttpMethod.POST.toString());
      serviceDataAirportCoreSvcV1CoreService.setServiceRequestContext(
          serviceRequestContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    loggerAirportCoreSvcV1CoreService.logRestClientRequest(
        HttpMethod.POST.name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        serviceRequestContextAirportCoreSvcV1CoreService.getBody());

    responseEntityAirportCoreSvcV1CoreService =
        restTemplateAirportCoreSvcV1CoreService.exchange(
            serviceRequestContextAirportCoreSvcV1CoreService.getUrl(),
            HttpMethod.POST,
            new HttpEntity<>(
                serviceRequestContextAirportCoreSvcV1CoreService.getBody(),
                serviceRequestContextAirportCoreSvcV1CoreService.getHeaders()),
            Object.class);

    loggerAirportCoreSvcV1CoreService.logRestClientResponse(
        HttpMethod.POST.name(),
        String.valueOf(responseEntityAirportCoreSvcV1CoreService.getStatusCode().value()),
        responseEntityAirportCoreSvcV1CoreService.getStatusCode().name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService = new ServiceResponseContext();
    serviceResponseContextAirportCoreSvcV1CoreService.setBody(
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService.setHeaders(
        responseEntityAirportCoreSvcV1CoreService.getHeaders());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService.setServiceResponseContext(
          serviceResponseContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    processPostAirportsResponse(serviceCallId);
    return null;
  }

  @Override
  @CircuitBreaker(name = "getAirport-cb", fallbackMethod = "processGetAirportFallback")
  @Bulkhead(name = "getAirport-bh")
  public Airport getAirport(String serviceCallId) {
    ServiceRequestContext serviceRequestContextAirportCoreSvcV1CoreService = null;
    ServiceResponseContext serviceResponseContextAirportCoreSvcV1CoreService = null;
    ResponseEntity<Airport> responseEntityAirportCoreSvcV1CoreService = null;
    ServiceData serviceDataAirportCoreSvcV1CoreService = null;
    serviceRequestContextAirportCoreSvcV1CoreService = processGetAirportRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextAirportCoreSvcV1CoreService);
    serviceRequestContextAirportCoreSvcV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriAirportCoreSvcV1CoreService + "/airports/{airportId}"))
            .queryParams(serviceRequestContextAirportCoreSvcV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextAirportCoreSvcV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextAirportCoreSvcV1CoreService.setMethod(HttpMethod.GET.name());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService = new ServiceData();
      serviceDataAirportCoreSvcV1CoreService.setName(serviceNameAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setVersion(serviceVersionAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setOperation(HttpMethod.GET.toString());
      serviceDataAirportCoreSvcV1CoreService.setServiceRequestContext(
          serviceRequestContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    loggerAirportCoreSvcV1CoreService.logRestClientRequest(
        HttpMethod.GET.name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        null);

    responseEntityAirportCoreSvcV1CoreService =
        restTemplateAirportCoreSvcV1CoreService.exchange(
            serviceRequestContextAirportCoreSvcV1CoreService.getUrl(),
            HttpMethod.GET,
            new HttpEntity<>(serviceRequestContextAirportCoreSvcV1CoreService.getHeaders()),
            Airport.class);

    loggerAirportCoreSvcV1CoreService.logRestClientResponse(
        HttpMethod.GET.name(),
        String.valueOf(responseEntityAirportCoreSvcV1CoreService.getStatusCode().value()),
        responseEntityAirportCoreSvcV1CoreService.getStatusCode().name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService = new ServiceResponseContext();
    serviceResponseContextAirportCoreSvcV1CoreService.setBody(
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService.setHeaders(
        responseEntityAirportCoreSvcV1CoreService.getHeaders());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService.setServiceResponseContext(
          serviceResponseContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    return processGetAirportResponse(serviceCallId);
  }

  @Override
  @CircuitBreaker(name = "putAirport-cb", fallbackMethod = "processPutAirportFallback")
  @Bulkhead(name = "putAirport-bh")
  public Object putAirport(String serviceCallId) {
    ServiceRequestContext serviceRequestContextAirportCoreSvcV1CoreService = null;
    ServiceResponseContext serviceResponseContextAirportCoreSvcV1CoreService = null;
    ResponseEntity<Object> responseEntityAirportCoreSvcV1CoreService = null;
    ServiceData serviceDataAirportCoreSvcV1CoreService = null;
    serviceRequestContextAirportCoreSvcV1CoreService = processPutAirportRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextAirportCoreSvcV1CoreService);
    serviceRequestContextAirportCoreSvcV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriAirportCoreSvcV1CoreService + "/airports/{airportId}"))
            .queryParams(serviceRequestContextAirportCoreSvcV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextAirportCoreSvcV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextAirportCoreSvcV1CoreService.setMethod(HttpMethod.PUT.name());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService = new ServiceData();
      serviceDataAirportCoreSvcV1CoreService.setName(serviceNameAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setVersion(serviceVersionAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setOperation(HttpMethod.PUT.toString());
      serviceDataAirportCoreSvcV1CoreService.setServiceRequestContext(
          serviceRequestContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    loggerAirportCoreSvcV1CoreService.logRestClientRequest(
        HttpMethod.PUT.name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        serviceRequestContextAirportCoreSvcV1CoreService.getBody());

    responseEntityAirportCoreSvcV1CoreService =
        restTemplateAirportCoreSvcV1CoreService.exchange(
            serviceRequestContextAirportCoreSvcV1CoreService.getUrl(),
            HttpMethod.PUT,
            new HttpEntity<>(
                serviceRequestContextAirportCoreSvcV1CoreService.getBody(),
                serviceRequestContextAirportCoreSvcV1CoreService.getHeaders()),
            Object.class);

    loggerAirportCoreSvcV1CoreService.logRestClientResponse(
        HttpMethod.PUT.name(),
        String.valueOf(responseEntityAirportCoreSvcV1CoreService.getStatusCode().value()),
        responseEntityAirportCoreSvcV1CoreService.getStatusCode().name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService = new ServiceResponseContext();
    serviceResponseContextAirportCoreSvcV1CoreService.setBody(
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService.setHeaders(
        responseEntityAirportCoreSvcV1CoreService.getHeaders());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService.setServiceResponseContext(
          serviceResponseContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    processPutAirportResponse(serviceCallId);
    return null;
  }

  @Override
  @CircuitBreaker(name = "deleteAirport-cb", fallbackMethod = "processDeleteAirportFallback")
  @Bulkhead(name = "deleteAirport-bh")
  public Object deleteAirport(String serviceCallId) {
    ServiceRequestContext serviceRequestContextAirportCoreSvcV1CoreService = null;
    ServiceResponseContext serviceResponseContextAirportCoreSvcV1CoreService = null;
    ResponseEntity<Object> responseEntityAirportCoreSvcV1CoreService = null;
    ServiceData serviceDataAirportCoreSvcV1CoreService = null;
    serviceRequestContextAirportCoreSvcV1CoreService = processDeleteAirportRequest(serviceCallId);
    setDefaultHeaders(serviceRequestContextAirportCoreSvcV1CoreService);
    serviceRequestContextAirportCoreSvcV1CoreService.setUrl(
        UriComponentsBuilder.fromHttpUrl(
                (baseUriAirportCoreSvcV1CoreService + "/airports/{airportId}"))
            .queryParams(serviceRequestContextAirportCoreSvcV1CoreService.getQueryParams())
            .buildAndExpand(serviceRequestContextAirportCoreSvcV1CoreService.getPathParams())
            .toUriString());
    serviceRequestContextAirportCoreSvcV1CoreService.setMethod(HttpMethod.DELETE.name());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService = new ServiceData();
      serviceDataAirportCoreSvcV1CoreService.setName(serviceNameAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setVersion(serviceVersionAirportCoreSvcV1CoreService);
      serviceDataAirportCoreSvcV1CoreService.setOperation(HttpMethod.DELETE.toString());
      serviceDataAirportCoreSvcV1CoreService.setServiceRequestContext(
          serviceRequestContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    loggerAirportCoreSvcV1CoreService.logRestClientRequest(
        HttpMethod.DELETE.name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        serviceRequestContextAirportCoreSvcV1CoreService.getBody());

    responseEntityAirportCoreSvcV1CoreService =
        restTemplateAirportCoreSvcV1CoreService.exchange(
            serviceRequestContextAirportCoreSvcV1CoreService.getUrl(),
            HttpMethod.DELETE,
            new HttpEntity<>(serviceRequestContextAirportCoreSvcV1CoreService.getHeaders()),
            Object.class);

    loggerAirportCoreSvcV1CoreService.logRestClientResponse(
        HttpMethod.DELETE.name(),
        String.valueOf(responseEntityAirportCoreSvcV1CoreService.getStatusCode().value()),
        responseEntityAirportCoreSvcV1CoreService.getStatusCode().name(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventType(),
        serviceRequestContextAirportCoreSvcV1CoreService.getEventMessage(),
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService = new ServiceResponseContext();
    serviceResponseContextAirportCoreSvcV1CoreService.setBody(
        responseEntityAirportCoreSvcV1CoreService.getBody());
    serviceResponseContextAirportCoreSvcV1CoreService.setHeaders(
        responseEntityAirportCoreSvcV1CoreService.getHeaders());
    if (serviceCallId != null) {
      serviceDataAirportCoreSvcV1CoreService.setServiceResponseContext(
          serviceResponseContextAirportCoreSvcV1CoreService);
      setServiceCallResult(serviceCallId, serviceDataAirportCoreSvcV1CoreService);
    }
    processDeleteAirportResponse(serviceCallId);
    return null;
  }
}
