package pers.xiaoming.java_spring.xml_aop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.List;

public class LoggingAspect {

    public LoggingAspect() {
    }

    /* using star to indicate any method
            could also be "execution(* CalculatorAopImpl.*(int, int))"
            means any access modifier and return type

            "execution(* pers.xiaoming.java_spring.aop_basic.annotation_aop.*.*(int, int))"
            means all the Classes in this package and all the methods of those classes whose parameters are two ints
        */
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@Before Running the <" + methodName + "> method begins with " + args);
    }


    //  Even tough exception throws, @After will still execute.
    //  But After advice cannot get the return value of the function.

    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@After <" + methodName + "> method ends. Running even though exception was threw ");
    }


    // Wont' run if exception throws.
    // But @AfterReturning method can get the target method's return value.
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> ends with " + result);
    }

    // Can access the exception object that throws by the target method
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> throws Exception: " + e.getMessage());
    }

    // Can specify execution for which Exception type!
    public void afterThrowingNullpointerException(JoinPoint joinPoint, NullPointerException e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> throws NullPointerException: " + e.getMessage());
    }

    // Can specify execution for which Exception type!
    public void afterThrowingArithmeticException(JoinPoint joinPoint, ArithmeticException e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> throws ArithmeticException: " + e.getMessage());
    }
}
