package br.aeso.ex01Maurício.exercício.modelo;

public class Fornecedor extends ProjectID {

	private Integer id;
	private String nome;
	private String cpf;
	private String banco;
	private Endereço endereço;

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

	public Endereço getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
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
				+ getCpf() + "\nEndereço = " + getEndereço() + "\nBanco = "
				+ getBanco();
	}

}
