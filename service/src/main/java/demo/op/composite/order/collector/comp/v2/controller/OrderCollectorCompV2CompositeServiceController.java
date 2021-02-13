package demo.op.composite.order.collector.comp.v2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.op.composite.order.collector.comp.v2.IOrderCollectorCompV2CompositeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.macys.mst.order.foundation.core.utils.validation.CreateGroup;
import com.macys.mst.order.foundation.core.utils.validation.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
/** */
@RestController
@Api("order-collector-service")
@RequiredArgsConstructor
public class OrderCollectorCompV2CompositeServiceController {

  private final IOrderCollectorCompV2CompositeService orderCollectorCompV2CompositeService;

  /** */
  @PostMapping(
      value = "/orders/collect",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "",
      tags = {},
      response = com.abcd.uop.model.Order.class)
  @ApiResponses({@ApiResponse(code = 200, message = "Order Collected")})
  public ResponseEntity<com.abcd.uop.model.Order> collectOrder(
      @RequestHeader(value = "", required = false) String OrderId,
      @RequestHeader(value = "", required = false) String MessageId,
      @RequestHeader(value = "", required = false) String CorrelationId,
      @RequestHeader(value = "", required = false) String ClientId,
      @ApiParam(value = "", required = true) @Validated({CreateGroup.class}) @RequestBody
          com.abcd.uop.model.Order body) {

    com.abcd.uop.model.Order data = orderCollectorCompV2CompositeService.collectOrder(body);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PutMapping(
      value = "/orders/collect",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "",
      tags = {},
      response = com.abcd.oop.model.Order.class)
  @ApiResponses({@ApiResponse(code = 200, message = "Order Collected")})
  public ResponseEntity<com.abcd.oop.model.Order> updateOrder(
      @RequestHeader(value = "", required = false) String OrderId,
      @RequestHeader(value = "", required = false) String MessageId,
      @RequestHeader(value = "", required = false) String CorrelationId,
      @RequestHeader(value = "", required = false) String ClientId,
      @ApiParam(value = "", required = true) @Validated({UpdateGroup.class}) @RequestBody
          com.abcd.oop.model.Order body) {

    com.abcd.oop.model.Order data = orderCollectorCompV2CompositeService.updateOrder(body);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
