package pers.xiaoming.java_framwork.spring_basic.aop_basic.annotation_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@EnableAspectJAutoProxy
@Component
public class AroundAdvice {

    /**
     *
     * Around advice should have parameter #ProceddingJoinPoint
     *
     * Around advice could control the whole process of the target method execution.
     * It could contain Before advice, After advice, AfterReturning advice and AfterThrowing advice.
     *
     * It is very similar to the dynamic proxy method.
     *
     * @return the target method executing result
     */


    @Around("execution(public double CalculatorAopImpl.divide(int, int))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        // @Before advice
        System.out.println("@Around @Before Running the <" + methodName + "> method begins with " + args);

        try {
            // execute the target method
            result = joinPoint.proceed();
            // @AfterReturning advice
            System.out.println("@Around @AfterReturning The methods <" + methodName + "> ends with " + result);
            // @After advice
            System.out.println("@Around @After <" + methodName + "> method ends. Running even though exception was threw ");
        } catch (Throwable e) {
            // @AfterThrowing advice
            System.out.println("@Around @AfterThrow The methods <" + methodName + "> throws Throwable: " + e.getMessage());
            // @After advice
            System.out.println("@Around @After <" + methodName + "> method ends. Running even though exception was threw ");
            throw new RuntimeException(e);
        }
        return result;
    }
}
