package jeff.study.tests.TestesSpring.AOP.anotacoes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InterceptorAround {

	
	@Around("execution( * jeff.study.tests.TestesSpring.AOP.anotacoes.Pessoa.* (..))")
	public void interceptar(ProceedingJoinPoint joinpoint) throws Throwable{
		long momentoInicial = System.currentTimeMillis();
		joinpoint.proceed();
		long tempo = System.currentTimeMillis() - momentoInicial;
		System.out.println("Tempo para executar = " + tempo + "ms");
		
	}
}
