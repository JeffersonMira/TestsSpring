package jeff.study.tests.TestesSpring.DBAccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		 ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/DBAccess/springconfgs/spring-beans.xml");
    	 
		
	}

}
