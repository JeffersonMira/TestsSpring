package jeff.study.tests.TestesSpring.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PessoaDAO {

	private DataSource datasource;
	private Connection con;
	
	public void inserir(Pessoa p){
		
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
	
	public List<Pessoa> findAll(){
		
		List<Pessoa> returnValue = new ArrayList<Pessoa>();
		try {
			con = datasource.getConnection();
			
			PreparedStatement ps = con.prepareStatement("Select * from pessoa");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				returnValue.add(new Pessoa(
						rs.getInt(1),
						rs.getString(2),
						rs.getLong(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
}
