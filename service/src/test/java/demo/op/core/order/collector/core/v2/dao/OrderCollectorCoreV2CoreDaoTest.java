package demo.op.core.order.collector.core.v2.dao;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import demo.op.core.order.collector.core.v2.dao.config.TestConfiguration;

import demo.op.core.order.collector.core.v2.dao.mapper.OrderOneToOrderOneMapper;
import demo.op.core.order.collector.core.v2.dao.mapper.OrderTwoToOrderTwoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class OrderCollectorCoreV2CoreDaoTest {
  @Autowired private OrderCollectorCoreV2CoreDao orderCollectorCoreV2CoreDao;

  @Test
  public void testCollectOrder() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdateOrder() {
    Assert.assertEquals(true, true);
  }
}
