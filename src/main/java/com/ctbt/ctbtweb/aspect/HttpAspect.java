package com.ctbt.ctbtweb.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);
}
