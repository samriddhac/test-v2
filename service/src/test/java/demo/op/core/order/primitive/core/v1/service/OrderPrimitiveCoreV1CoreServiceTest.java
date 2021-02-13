package demo.op.core.order.primitive.core.v1.service;

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

import demo.op.core.order.primitive.core.v1.dao.OrderPrimitiveCoreV1CoreDao;
import demo.op.core.order.primitive.core.v1.service.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class OrderPrimitiveCoreV1CoreServiceTest {

  @Autowired private OrderPrimitiveCoreV1CoreService orderPrimitiveCoreV1CoreService;

  @Test
  public void testGetOrderIdForCustomerOrderIdOrReservationId() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
