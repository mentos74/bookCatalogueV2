package com.mentos74.catalogue.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.mentos74.catalogue.web.BookResource.*(..))")
    private void restAPI() {
    }

    @Before("restAPI()")
    private void beforeExecuteLoggig() {
        log.info("log sebelum eksekusi");
    }


}
