package jeff.study.tests.TestesSpring.DBAccess;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaDAOHibernate{ //extends GenericHibernateDAO<Pessoa>{

	private SessionFactory sessionFactory;

	protected Session getSession(){
		return this.getSessionFactory().getCurrentSession();
	}

	public void persistir(Pessoa obj){
		this.getSession().saveOrUpdate(obj);
		System.out.println("persistido");
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
