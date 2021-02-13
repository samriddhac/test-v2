package demo.op.core.airport.core.svc.v1.service.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import demo.op.core.airport.core.svc.v1.dao.AirportCoreSvcV1CoreDao;

@Configuration
@ComponentScan(basePackages = "demo.op.core.airport.core.svc.v1.service")
public class TestConfiguration {
  @MockBean public AirportCoreSvcV1CoreDao airportCoreSvcV1CoreDao;
}
