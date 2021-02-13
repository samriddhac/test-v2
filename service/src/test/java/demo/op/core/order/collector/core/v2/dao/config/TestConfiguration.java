package demo.op.core.order.collector.core.v2.dao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.op.core.order.collector.core.v2.dao.mapper.OrderOneToOrderOneMapper;
import demo.op.core.order.collector.core.v2.dao.mapper.OrderTwoToOrderTwoMapper;

@Configuration
@ComponentScan(basePackages = "demo.op.core.order.collector.core.v2.dao")
public class TestConfiguration {

  @MockBean public OrderOneToOrderOneMapper orderOneToOrderOneMapper;

  @MockBean public OrderTwoToOrderTwoMapper orderTwoToOrderTwoMapper;
  @MockBean public SpannerTemplate spannerTemplate;
}
