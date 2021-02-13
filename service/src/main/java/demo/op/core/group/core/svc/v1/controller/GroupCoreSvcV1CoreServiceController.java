package demo.op.core.group.core.svc.v1.controller;

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
import com.abcd.uop.model.Order;
import demo.op.core.group.core.svc.v1.service.GroupCoreSvcV1CoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

/** */
@RestController
@Api("releasegroup-service")
@RequiredArgsConstructor
public class GroupCoreSvcV1CoreServiceController {

  private final GroupCoreSvcV1CoreService groupCoreSvcV1CoreService;

  /** */
  @PostMapping(
      value = "/op/v1/order/release/logicalshipments",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Order.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "OK"),
    @ApiResponse(code = 201, message = "Created")
  })
  public ResponseEntity<List<List<Order>>> groupLogicalShipments(
      @ApiParam(value = "lineItemArray", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          List<Order> lineItemArray) {
    List<List<Order>> data = groupCoreSvcV1CoreService.groupLogicalShipments(lineItemArray);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
