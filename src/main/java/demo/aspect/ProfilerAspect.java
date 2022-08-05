package demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class ProfilerAspect {

  @Around("@annotation(demo.aspect.LogExecutionTime)")
  public Object logExecutionTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    final MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

    final String className = methodSignature.getDeclaringType().getSimpleName();
    final String methodName = methodSignature.getName();

    final StopWatch stopWatch = new StopWatch();

    stopWatch.start();
    Object result = proceedingJoinPoint.proceed();
    stopWatch.stop();

    LOGGER.info("{}::{} took {} ms", className, methodName, stopWatch.getTotalTimeMillis());

    return result;
  }
}
