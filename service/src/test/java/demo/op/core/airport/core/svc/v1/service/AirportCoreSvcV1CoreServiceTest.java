package demo.op.core.airport.core.svc.v1.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import demo.op.core.airport.core.svc.v1.dao.AirportCoreSvcV1CoreDao;
import demo.op.core.airport.core.svc.v1.service.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class AirportCoreSvcV1CoreServiceTest {

  @Autowired private AirportCoreSvcV1CoreService airportCoreSvcV1CoreService;

  @Test
  public void testGetAirports() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testPostAirports() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetAirport() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testPutAirport() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteAirport() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
