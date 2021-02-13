package demo.op.core.order.collector.core.v1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import com.macys.mst.order.foundation.core.utils.validation.CreateGroup;
import com.macys.mst.order.foundation.core.utils.validation.UpdateGroup;
import com.macys.uop.model.Order;
import demo.op.core.order.collector.core.v1.service.OrderCollectorCoreV1CoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

/** */
@RestController
@Api("order-service")
@RequiredArgsConstructor
public class OrderCollectorCoreV1CoreServiceController {

  private final OrderCollectorCoreV1CoreService orderCollectorCoreV1CoreService;

  /** */
  @PostMapping(
      value = "/orders",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "",
      tags = {},
      response = Order.class)
  @ApiResponses({@ApiResponse(code = 201, message = "Order Created")})
  public ResponseEntity<Order> createOrder(
      @ApiParam(value = "", required = true) @Validated({CreateGroup.class}) @RequestBody
          Order body) {
    Order data = orderCollectorCoreV1CoreService.createOrder(body);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
