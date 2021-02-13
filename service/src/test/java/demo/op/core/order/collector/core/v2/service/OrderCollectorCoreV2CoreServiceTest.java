package demo.op.core.order.collector.core.v2.service;

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

import demo.op.core.order.collector.core.v2.dao.OrderCollectorCoreV2CoreDao;
import demo.op.core.order.collector.core.v2.service.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class OrderCollectorCoreV2CoreServiceTest {

  @Autowired private OrderCollectorCoreV2CoreService orderCollectorCoreV2CoreService;

  @Test
  public void testCollectOrder() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdateOrder() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
