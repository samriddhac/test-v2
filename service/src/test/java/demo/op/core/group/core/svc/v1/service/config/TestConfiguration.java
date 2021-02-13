package demo.op.core.group.core.svc.v1.service.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import demo.op.core.group.core.svc.v1.dao.GroupCoreSvcV1CoreDao;

@Configuration
@ComponentScan(basePackages = "demo.op.core.group.core.svc.v1.service")
public class TestConfiguration {
  @MockBean public GroupCoreSvcV1CoreDao groupCoreSvcV1CoreDao;
}
