package com.baoviet.mhol.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jigish Patel
 */

@Component
@Aspect
@Order(1)
public class ExecutionTimeAdvice {

    Logger logger = LoggerFactory.getLogger(ExecutionTimeAdvice.class);

    @Around("execution(* com.baoviet.mhol.web.controller..*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        logger.info(String.format("Enters on method: %s. \n", pjp.getSignature()));

        Object[] arguments = pjp.getArgs();
        for (int i =0; i < arguments.length; i++){
            Object argument = arguments[i];
            if (argument != null){
                logger.info(String.format("With argument of type %s and value %s. \n", argument.getClass().toString(), argument));
            }
        }

        long startTime = System.nanoTime();
        Object retVal = pjp.proceed();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        logger.info("Method " + pjp.getSignature() + " took " + duration + " ns (" + (duration/1000000.0) + " ms, " + (duration/1000000000.0) + " s).");

        logger.info(String.format("Exits method: %s. \n", pjp.getSignature()));

        return retVal;
    }
}