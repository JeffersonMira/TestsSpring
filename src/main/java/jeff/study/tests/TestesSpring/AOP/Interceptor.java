package jeff.study.tests.TestesSpring.AOP;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Interceptor implements MethodBeforeAdvice{

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
		if(arg0.getName().equals("salvarPessoa")){
			System.out.println("Vai salvar a parada!!");
		}
	}


	
	
}
