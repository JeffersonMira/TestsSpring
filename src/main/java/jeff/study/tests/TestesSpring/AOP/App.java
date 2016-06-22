package jeff.study.tests.TestesSpring.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jeff.study.tests.TestesSpring.AOP.anotacoes.Pessoa;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
//       ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/AOP/springconfgs/spring-beans.xml");
//       
//       Pessoa p = (Pessoa)ap.getBean("pessoaProxy");
//       System.out.println(p.getNome());
//       
//       p.salvarPessoa();
    	
    	
    	 ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/AOP/springconfgs/spring-beans-Anotations.xml");
    	 
    	 Pessoa p = (Pessoa) ap.getBean("pessoa");
    	 
    	 p.salvarPessoa();
         
    }
}
