package jeff.study.tests.TestesSpring.DBAccess;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PessoaDAO {

	private ComboPooledDataSource datasource;
	
	
	

	public ComboPooledDataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(ComboPooledDataSource datasource) {
		this.datasource = datasource;
	}
	
}
