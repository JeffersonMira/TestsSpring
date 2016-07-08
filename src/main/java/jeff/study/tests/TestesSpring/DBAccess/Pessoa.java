package jeff.study.tests.TestesSpring.DBAccess;

import javax.persistence.*;

@Entity
@Table(name="pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String name;
	
	@Column(name="telefone")
	private Long phone;

	
	public Pessoa() {
		super();
	}
	
	public Pessoa(Integer id, String name, Long phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
