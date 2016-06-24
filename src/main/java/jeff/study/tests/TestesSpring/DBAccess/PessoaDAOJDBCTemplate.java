package jeff.study.tests.TestesSpring.DBAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * Também é possível fazer o processamento em lote utilizando o BatchPreparedStatementSetter
 * */
public class PessoaDAOJDBCTemplate {

	private JdbcTemplate jdbcTemplate;
	private Connection con;
	/*
	 * Seria possível também criar uma classe que implementasse o mapRow, que inclusive eu acho ser 
	 * o melhor a ser feito. Mas apenas para fins de estudo, está valendo.
	 * */
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
	
	/*O update tbm é bem simples*/
	public void update(Pessoa pessoa) {
		getJdbcTemplate().update("update pessoa set nome = ? where id = ?",
				pessoa.getName(), pessoa.getId());
	}
	
	/*
	 * Este 'Execute' pode ser utilizado para executar qualquer comando SQL.
	 * Inclusive DDL.*/
	public void createTable(){
		
		String ddl = "create table assunto(" +
				"id long auto_increment not null, " +
				"nome varchar(255) not null, " +
				"primary key(id))";
				getJdbcTemplate().execute(ddl);
	}
	
	public Long Insert(Pessoa p){
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("nome", p.getName());
		parameters.put("telefone", p.getPhone());
		
		/*
		 * Utiliza o design pattern 'builder' e já retorna o valor gerado automágicamente.*/
		Long id = new SimpleJdbcInsert(getJdbcTemplate())
				.withTableName("pessoa")
				.usingGeneratedKeyColumns("id")
				.executeAndReturnKey(parameters).longValue();
		
		return id;
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
