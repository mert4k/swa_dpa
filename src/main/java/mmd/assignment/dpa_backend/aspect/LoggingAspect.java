package mmd.assignment.dpa_backend.aspect;

import mmd.assignment.dpa_backend.controller.SubscriberController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(public * mmd.assignment.dpa_backend.controller.*.*(..))")
    private void publicEndpointsFromControllers() {
    }

    @Around(value = "publicEndpointsFromControllers()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        logger.debug(">> {}() - {}", methodName, Arrays.toString(args));
        Object result = joinPoint.proceed();
        logger.debug("<< {}() - {}", methodName, result);
        return result;
    }
}