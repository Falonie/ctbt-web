package com.ctbt.ctbtweb.aspect;

import com.ctbt.ctbtweb.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Slf4j
public class HttpAspect {
    //    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.ctbt.ctbtweb.service.ShipsService.*(..))")
    public void shipLog() {
    }

    //    @AfterReturning(value = "execution(* com.ctbt.ctbtweb.service.*.*(..))")
//    public void afterReturning(JoinPoint joinPoint) {
    @AfterReturning(pointcut = "shipLog()")
    public void afterReturning(JoinPoint joinPoint) {
        Log logger = new Log();
        String operation = joinPoint.getSignature().getName();
        log.info("******************" + joinPoint.getTarget().getClass().getName());
        log.info("**********************" + joinPoint.getSignature().getName());
    }
}
