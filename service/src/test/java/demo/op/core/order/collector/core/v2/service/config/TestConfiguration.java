package demo.op.core.order.collector.core.v2.service.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import demo.op.core.order.collector.core.v2.dao.OrderCollectorCoreV2CoreDao;

@Configuration
@ComponentScan(basePackages = "demo.op.core.order.collector.core.v2.service")
public class TestConfiguration {
  @MockBean public OrderCollectorCoreV2CoreDao orderCollectorCoreV2CoreDao;
}
