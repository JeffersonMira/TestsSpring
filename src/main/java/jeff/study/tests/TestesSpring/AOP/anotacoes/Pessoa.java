package jeff.study.tests.TestesSpring.AOP.anotacoes;

import java.io.IOException;

public class Pessoa {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void salvarPessoa() throws Exception{
		System.out.println("salvando pessoa");
	}
	
}
