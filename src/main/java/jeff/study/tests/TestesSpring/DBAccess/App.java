package jeff.study.tests.TestesSpring.DBAccess;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

//		 ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/DBAccess/springconfgs/spring-beans.xml");
//    	 
//		 PessoaDAO pDAO = (PessoaDAO)ap.getBean("pessoaDAO");
//		 Pessoa p = new Pessoa();
//		 p.setName("João");
//		 p.setPhone(12345L);
//		 pDAO.inserir(p);
//		 List<Pessoa> ps =  pDAO.findAll();
		 
		 
		 ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/DBAccess/springconfgs/spring-beans-jdbctemplate.xml");
		 PessoaDAOJDBCTemplate p = (PessoaDAOJDBCTemplate) ap.getBean("pessoaDAOJDBCTemplate");
		 
		 System.out.println("\n------------  Test 1 --------------------");
		 List<Pessoa> ps = p.findAll();
		 
		 for (Pessoa pessoa : ps) {
			System.out.println(pessoa.toString());
		}
		 
		 System.out.println("\n------------  Test 2 --------------------");
		 
		 Pessoa pChanged = ps.get(ps.size()-1);
		 pChanged.setName("Amaterasu");
		 p.update(pChanged);
		 
		 ps = p.findAll();
		 
		 for (Pessoa pessoa : ps) {
			System.out.println(pessoa.toString());
		}
		 
		System.out.println("\n------------  Test 3 --------------------");
		 
		 Pessoa pOther = new Pessoa();
		 pOther.setName("Madara");
		 pOther.setPhone(12347L);
		 Long id = p.Insert(pOther);
		 System.out.println("Id Inserted is: "+id);
		 
		 
		 
	}

}
