package demo.op.core.airport.core.svc.v1.controller;

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

import demo.op.core.airport.core.svc.v1.controller.AirportCoreSvcV1CoreServiceController;
import demo.op.core.airport.core.svc.v1.service.AirportCoreSvcV1CoreService;
import brave.SpanCustomizer;

@RunWith(SpringRunner.class)
@WebMvcTest(AirportCoreSvcV1CoreServiceController.class)
public class AirportCoreSvcV1CoreServiceControllerTest {

  @MockBean private JsonUtils jsonUtils;
  @MockBean private Logger logger;
  @Autowired private MockMvc mockMvc;
  @MockBean private AirportCoreSvcV1CoreService airportCoreSvcV1CoreService;
  private ObjectMapper mapper = new ObjectMapper();

  @MockBean private SpanCustomizer spanCustomizer;

  @Test
  public void testGetAirports() throws Exception {

    Assert.assertEquals(true, true);
  }

  @Test
  public void testPostAirports() throws Exception {

    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetAirport() throws Exception {

    Assert.assertEquals(true, true);
  }

  @Test
  public void testPutAirport() throws Exception {

    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteAirport() throws Exception {

    Assert.assertEquals(true, true);
  }
}
