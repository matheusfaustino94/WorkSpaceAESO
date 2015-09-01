package br.aeso.ex01Maurício.exercício.modelo;

public class Endereço extends ProjectID {

	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private Fornecedor fornecedor;
	private Integer ID = 0;

	public Endereço(String rua, String numero, String complento, String bairro,
			String cidade, String cep, String complemento) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public Integer getID() {
		return this.ID;
	}

	@Override
	public void setID(Integer id) {
		this.ID = id;
	}

	@Override
	public String toString() {
		return "Endereço:" + "\nID:" + ID + "\nID_Fornecedor:"
				+ fornecedor.getID() + "\nRua:" + rua + "\nCidade: " + cidade
				+ "\nBairro: " + bairro + "\nNumero :" + numero
				+ "\nComplemento: " + complemento + "\nCEP: " + cep;
	}

}
