package jeff.study.tests.TestesSpring.DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PessoaDAOJDBCTemplate {

	private JdbcTemplate jdbcTemplate;
	private Connection con;
	
	public void inserir(Pessoa p){
		
	}
	
	public List<Pessoa> findAll(){

		return jdbcTemplate.query("select * from pessoa", 

				new RowMapper<Pessoa>(){

			public Pessoa mapRow(ResultSet rs, int rownum) throws SQLException {
				return new Pessoa(
						rs.getInt(1),
						rs.getString(2),
						rs.getLong(3));
			}

		});
		
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
}
