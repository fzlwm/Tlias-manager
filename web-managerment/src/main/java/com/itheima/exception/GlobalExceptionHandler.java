package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("异常:",e);
        return Result.error("服务器异常");
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("异常:",e);
        String msg = e.getMessage();
        int index = msg.indexOf("Duplicate entry");
        String errorMsg = msg.substring(index);
        String eMas = errorMsg.split(" ")[2];
        return Result.error(eMas+"已存在");
    }
}
