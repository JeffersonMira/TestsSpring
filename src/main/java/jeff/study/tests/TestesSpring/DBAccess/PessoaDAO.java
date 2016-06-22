package jeff.study.tests.TestesSpring.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class PessoaDAO {

	private DataSource datasource;
	
	public void inserir(Pessoa p){
		Connection con = null;
		try {
			con = datasource.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into pessoa(nome, telefone) values(?,?)");
			ps.setString(1, p.getName());
			ps.setLong(2, p.getPhone());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
}
