package demo.op.core.order.collector.core.v2.exception.impl;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.zalando.problem.Status;

import com.macys.mst.order.foundation.core.utils.CommonStatusCode;
import com.macys.mst.order.foundation.core.utils.exception.ErrorDetail;
import com.macys.mst.order.foundation.core.utils.exception.ExceptionHandler;
import com.macys.mst.order.foundation.core.utils.exception.ProblemUtil;
import com.macys.mst.order.foundation.core.utils.execution.ServiceContextUtil;
import com.macys.mst.order.foundation.core.utils.logging.LoggingUtil;

import io.grpc.StatusRuntimeException;

public class DataExceptionHandler
    implements ExceptionHandler, ServiceContextUtil, ProblemUtil, LoggingUtil {

  @Override
  public void handleException(JoinPoint joinPoint, Throwable error) {
    // HINT: your code goes here...
    Throwable throwable = ExceptionUtils.getRootCause(error);
    StatusRuntimeException sre = null;
    if (throwable instanceof io.grpc.StatusRuntimeException) {
      sre = (StatusRuntimeException) throwable;
      com.macys.mst.order.foundation.core.utils.exception.Error dataError =
          com.macys.mst.order.foundation.core.utils.exception.Error.builder()
              .withCode(CommonStatusCode.DB_ERROR.getCode())
              .withMessage(CommonStatusCode.DB_ERROR.getDescription())
              .withErrorDetail(
                  ErrorDetail.builder()
                      .withDomain(getServiceRequestContext().getApplicationName())
                      .withReason("Spanner Error")
                      .withMessage(sre.getMessage())
                      .withLocation("Spanner Database")
                      .build())
              .build();
      getErrorLogMessageBuilder(
              CommonStatusCode.DB_ERROR.getCode(),
              CommonStatusCode.DB_ERROR.getDescription(),
              error)
          .build()
          .logAsError();
      throw createProblem(Status.INTERNAL_SERVER_ERROR.getStatusCode(), dataError, error);
    } else {
      getErrorLogMessageBuilder(
              CommonStatusCode.DB_ERROR.getCode(),
              CommonStatusCode.DB_ERROR.getDescription(),
              error)
          .build()
          .logAsError();
      throw createProblem(
          Status.INTERNAL_SERVER_ERROR.getStatusCode(),
          CommonStatusCode.DB_ERROR.getCode(),
          CommonStatusCode.DB_ERROR.getDescription(),
          error);
    }
  }
}
