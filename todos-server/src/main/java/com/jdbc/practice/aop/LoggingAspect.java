package com.jdbc.practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(
            pointcut = "within(com.jdbc.practice.service..*)"
    )
    public void loggingServices(JoinPoint joinPoint) {
        LOGGER.info("{} started execution with args: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(value = "within(com.jdbc.practice.controller..*)", returning = "retVal")
    public void loggingController(JoinPoint joinPoint, Object retVal) {
        LOGGER.info("Endpoint {} was triggered and return {}", joinPoint.getSignature().getName(), retVal);
    }
}