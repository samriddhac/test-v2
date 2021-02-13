package demo.op.core.airport.core.svc.v1.dao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.op.core.airport.core.svc.v1.dao.mapper.*;

@Configuration
@ComponentScan(basePackages = "demo.op.core.airport.core.svc.v1.dao")
public class TestConfiguration {

  @MockBean public AirportToAirportMapper airportToAirportMapper;
  @MockBean public SpannerTemplate spannerTemplate;
}
