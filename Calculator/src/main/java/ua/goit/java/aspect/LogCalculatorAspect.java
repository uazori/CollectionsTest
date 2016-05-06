package ua.goit.java.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Vadim on 03.05.2016.
 */

@Aspect
public class LogCalculatorAspect {
    final static Logger logger = Logger.getLogger(LogCalculatorAspect.class);

    @Around("execution(* ua.goit.calculator.Calculator.*(..)) ")
    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {


        logger.info("Before Calculator call method: " + pjp.getSignature().getName());

        Object result = pjp.proceed();

        logger.info("After Calculator call method: " + pjp.getSignature().getName());

        return result;
    }
}

