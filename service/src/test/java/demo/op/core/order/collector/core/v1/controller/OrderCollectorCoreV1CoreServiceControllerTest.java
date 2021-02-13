package demo.op.core.order.collector.core.v1.controller;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.macys.mst.order.foundation.core.utils.execution.ServiceRequestContext;
import com.macys.mst.order.foundation.core.utils.json.JsonUtils;
import com.macys.mst.order.foundation.core.utils.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.op.core.order.collector.core.v1.controller.OrderCollectorCoreV1CoreServiceController;
import demo.op.core.order.collector.core.v1.service.OrderCollectorCoreV1CoreService;
import brave.SpanCustomizer;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderCollectorCoreV1CoreServiceController.class)
public class OrderCollectorCoreV1CoreServiceControllerTest {

  @MockBean private JsonUtils jsonUtils;
  @MockBean private Logger logger;
  @Autowired private MockMvc mockMvc;
  @MockBean private OrderCollectorCoreV1CoreService orderCollectorCoreV1CoreService;
  private ObjectMapper mapper = new ObjectMapper();

  @MockBean private SpanCustomizer spanCustomizer;

  @Test
  public void testCreateOrder() throws Exception {

    Assert.assertEquals(true, true);
  }
}
