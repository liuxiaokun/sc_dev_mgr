package com.lxk.mgr.exception;

import com.lxk.mgr.controller.base.RO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:00
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RO exceptionHandler(Exception e) {
        log.error("全局异常捕获", e);
        return RO.fail("服务器异常");
    }
}
