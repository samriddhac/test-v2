package demo.op.composite.order.primitive.comp.v2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.op.composite.order.primitive.comp.v2.IOrderPrimitiveCompV2CompositeService;

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
@Api("order-core-service")
@RequiredArgsConstructor
public class OrderPrimitiveCompV2CompositeServiceController {

  private final IOrderPrimitiveCompV2CompositeService orderPrimitiveCompV2CompositeService;

  /** */
  @GetMapping(
      value = "/op/v1/order/orderid",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Double.class)
  @ApiResponses({@ApiResponse(code = 200, message = "OK")})
  public ResponseEntity<Double> getOrderIdForCustomerOrderIdOrReservationId(
      @ApiParam(value = "customerOrderId", required = false)
          @RequestParam(value = "customerOrderId", required = true)
          String customerOrderId,
      @ApiParam(value = "reservationId", required = false)
          @RequestParam(value = "reservationId", required = true)
          String reservationId) {

    Double data =
        orderPrimitiveCompV2CompositeService.getOrderIdForCustomerOrderIdOrReservationId();
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
