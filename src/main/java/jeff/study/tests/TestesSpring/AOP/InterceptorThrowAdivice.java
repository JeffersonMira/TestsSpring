package jeff.study.tests.TestesSpring.AOP;

import java.io.IOException;
import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class InterceptorThrowAdivice implements ThrowsAdvice{

	public InterceptorThrowAdivice() {
	}
	
	
	public void afterThrowing(Method method, Object[] args, Object target, IOException e){
		System.out.println("Deu uma Exception "+e.getMessage());
		
	}
	
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		System.out.println("Deu uma Exceptionsss "+ex.getMessage());
		
	}
	
	
}
