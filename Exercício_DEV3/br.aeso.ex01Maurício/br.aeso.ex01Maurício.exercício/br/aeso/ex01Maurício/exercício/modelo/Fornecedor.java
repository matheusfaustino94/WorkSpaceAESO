package br.aeso.ex01Maur�cio.exerc�cio.modelo;

public class Fornecedor extends ProjectID {

	private Integer id;
	private String nome;
	private String cpf;
	private String banco;
	private Endere�o endere�o;

	public Fornecedor(String nome, String cpf, String banco) {
		this.nome = nome;
		this.cpf = cpf;
		this.banco = banco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Endere�o getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(Endere�o endere�o) {
		this.endere�o = endere�o;
	}

	@Override
	public Integer getID() {
		return this.id;
	}

	@Override
	public void setID(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n- Fornecedor -" + "\nNome = " + getNome() + "\nCPF = "
				+ getCpf() + "\nEndere�o = " + getEndere�o() + "\nBanco = "
				+ getBanco();
	}

}
