package br.senai.sc.tii2014.n1.anna.cadastrogatos.model.entity;

public class Gato {
	
	private long id;
	private String nome;
	private String raca;
	
	public Gato(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	

}
