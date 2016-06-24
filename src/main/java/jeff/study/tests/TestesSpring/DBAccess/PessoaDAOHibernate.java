package jeff.study.tests.TestesSpring.DBAccess;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaDAOHibernate{ //extends GenericHibernateDAO<Pessoa>{

	@Autowired
	private SessionFactory sessionFactory;

	
	protected Session getSession(){
		return this.getSessionFactory().getCurrentSession();
	}
	
	public void persistir(Pessoa obj){
		this.getSession().saveOrUpdate(obj);;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
