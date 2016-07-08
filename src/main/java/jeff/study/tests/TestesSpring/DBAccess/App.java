package jeff.study.tests.TestesSpring.DBAccess;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
//		 testConnectionJDBC();
//		 testConnectionJDBCTemplate();
		testConnectionHibernate();
		
		
		 
	}

	public static void testConnectionJDBC(){
		 ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/DBAccess/springconfgs/spring-beans.xml");
   	 
		 PessoaDAO pDAO = (PessoaDAO)ap.getBean("pessoaDAO");
		 Pessoa p = new Pessoa();
		 p.setName("João");
		 p.setPhone(12345L);
		 pDAO.inserir(p);
		 List<Pessoa> ps =  pDAO.findAll();
		 
		 
		 System.out.println("\n------------  Test 1 --------------------");
		 for (Pessoa pessoa : ps) {
			System.out.println(pessoa.toString());
		}
	}
	
	public static void testConnectionJDBCTemplate(){
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
	
	
	/**
	 * Não funciona. Está dando erro: 
	 * Exception in thread "main" org.springframework.orm.hibernate3.HibernateSystemException:
	 *  No Hibernate Session bound to thread, and configuration does not allow creation of 
	 *  non-transactional one here; nested exception is org.hibernate.HibernateException: 
	 *  No Hibernate Session bound to thread, and configuration does not allow creation of 
		on-transactional one here
	 */
	public static void testConnectionHibernate(){
		 ApplicationContext ap =  new ClassPathXmlApplicationContext("file:src/main/java/jeff/study/tests/TestesSpring/DBAccess/springconfgs/spring-beans-hibernate.xml");
		 PessoaDAOHibernate p = (PessoaDAOHibernate) ap.getBean("pessoaDAOHibernate");
		 p.persistir(getPessoa());
		 
	}
	
	private static Pessoa getPessoa(){
		 Pessoa pOther = new Pessoa();
		 pOther.setName("Madara");
		 pOther.setPhone(12347L);
		 return pOther;
	}
}
