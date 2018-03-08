package com.beyondli.common.exception;

import com.beyondli.common.tools.uuid.UUIDUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/8/1 下午5:10
 * @desc 全局异常捕捉并转换异常
 */
@Log4j
@RestControllerAdvice(basePackages = "com.beyondli.rest")
public class GlobalExceptionHandler {

    private String appName = "sentiment";

    private String ip = "127.0.0.1";

    @Resource
    ExceptionManager exceptionManager;

    /**
     * 校验异常
     * @param e
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public String handlerException(ConstraintViolationException e) {
        String code = e.getConstraintViolations().stream().limit(1).map(vio -> vio.getMessageTemplate())
                 .collect(Collectors.toList()).get(0);
        PhantomException exception = exceptionManager.create(code);
        exception.setStackTrace(e.getStackTrace());

        PhantomException phantomException = exceptionManager.create(exception);
        log.error(logTraceInfo(phantomException));
        return phantomException.toString();
    }

    /**
     * 如果是自定义异常
     * @param e
     */
    @ExceptionHandler(PhantomException.class)
    @ResponseStatus(BAD_REQUEST)
    public PhantomException handlerException(PhantomException e) {
        PhantomException phantomException = exceptionManager.create(e);
        log.error(logTraceInfo(phantomException));
        return phantomException;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        PhantomException exception = new PhantomException(UUIDUtils.getUUID(), appName, ip, "SYSTEM_ERR", e.getMessage());
        //复制异常栈
        exception.setStackTrace(e.getStackTrace());

        PhantomException phantomException = exceptionManager.create(exception);
        log.error(logTraceInfo(phantomException));
        log.error(logTraceInfo(e));
        return phantomException.toString();
    }

    /**
     * KingBoy实现异常栈信息打印，通过查看源码
     * @param e
     * @return
     */
    private String logTraceInfo(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e);
        for (StackTraceElement traceElement : trace) {
            sb.append("\n\tat " + traceElement);
        }
        return sb.toString();
    }

}
