package demo.op.core.order.core.v1.service.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import demo.op.core.order.core.v1.dao.OrderCoreV1CoreDao;

@Configuration
@ComponentScan(basePackages = "demo.op.core.order.core.v1.service")
public class TestConfiguration {
  @MockBean public OrderCoreV1CoreDao orderCoreV1CoreDao;
}
