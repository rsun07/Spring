package pers.xiaoming.java_spring.annotation_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// initialize the class as an Aspect, inject to IOC container
@Aspect
// Don't forget this
// Enable auto generator of Proxy beans
@EnableAspectJAutoProxy

// we can use @Order to set the priority of an Aspect
// the less the number is, the higher the priority is
@Order(1)

@Component
public class LoggingAspect {

    /**
     * Use to define the <Joint Point> for duplicate .
     */
    @Pointcut("execution(public int CalculatorAopImpl.*(int, int))")
    public void declareJointPointExpress() {

    }

    /* using star to indicate any method
        could also be "execution(* CalculatorAopImpl.*(int, int))"
        means any access modifier and return type

        "execution(* pers.xiaoming.java_spring.aop_basic.annotation_aop.*.*(int, int))"
        means all the Classes in this package and all the methods of those classes whose parameters are two ints
    */
    @Before("declareJointPointExpress()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@Before Running the <" + methodName + "> method begins with " + args);
    }


    // declareJointPointExpress() is defined above, used like a variable for common packagees, classes and methods
    @After("declareJointPointExpress()")
    //  Even tough exception throws, @After will still execute.
    //  But After advice cannot get the return value of the function.
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@After <" + methodName + "> method ends. Running even though exception was threw ");
    }


    // Wont' run if exception throws.
    // But @AfterReturning method can get the target method's return value.
    @AfterReturning(value = "declareJointPointExpress()",
                    returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterReturning The methods <" + methodName + "> ends with " + result);
    }

    // Can access the exception object that throws by the target method
    @AfterThrowing(value = "execution(public int CalculatorAopImpl.*(int, int))",
                   throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> throws Exception: " + ex.getMessage());
    }

    // Can specify execution for which Exception type!
    @AfterThrowing(value = "execution(public int CalculatorAopImpl.*(int, int))",
            throwing = "ex")
    public void afterThrowingNullpointerException(JoinPoint joinPoint, NullPointerException ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> throws NullPointerException: " + ex.getMessage());
    }

    // Can specify execution for which Exception type!
    @AfterThrowing(value = "execution(public int CalculatorAopImpl.*(..))",
            throwing = "ex")
    public void afterThrowingArithmeticException(JoinPoint joinPoint, ArithmeticException ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing The methods <" + methodName + "> throws ArithmeticException: " + ex.getMessage());
    }
}
