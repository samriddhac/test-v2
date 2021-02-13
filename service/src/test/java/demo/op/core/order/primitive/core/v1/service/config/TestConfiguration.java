package demo.op.core.order.primitive.core.v1.service.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import demo.op.core.order.primitive.core.v1.dao.OrderPrimitiveCoreV1CoreDao;

@Configuration
@ComponentScan(basePackages = "demo.op.core.order.primitive.core.v1.service")
public class TestConfiguration {
  @MockBean public OrderPrimitiveCoreV1CoreDao orderPrimitiveCoreV1CoreDao;
}
