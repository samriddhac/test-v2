package demo.op.core.order.collector.core.v1.service.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import demo.op.core.order.collector.core.v1.dao.OrderCollectorCoreV1CoreDao;

@Configuration
@ComponentScan(basePackages = "demo.op.core.order.collector.core.v1.service")
public class TestConfiguration {
  @MockBean public OrderCollectorCoreV1CoreDao orderCollectorCoreV1CoreDao;
}
