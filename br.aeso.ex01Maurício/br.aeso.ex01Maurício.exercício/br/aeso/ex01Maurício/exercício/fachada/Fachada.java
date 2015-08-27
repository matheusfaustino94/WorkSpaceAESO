package br.aeso.ex01Maurício.exercício.fachada;

import java.util.ArrayList;

import br.aeso.ex01Maurício.exercício.controlador.ControladorFornecedor;
import br.aeso.ex01Maurício.exercício.controlador.IControlador;
import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.modelo.Fornecedor;

public class Fachada {

	IControlador<Fornecedor> controladorFornecedor;
	private static Fachada fachada;

	public Fachada() {
		controladorFornecedor = new ControladorFornecedor();
	}

	public static Fachada getInstance() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	public void cadastrarFornecedor(Fornecedor fornecedor)
			throws projetoException {
		controladorFornecedor.cadastrarEntities(fornecedor);
	}

	public void atualizarFornecedor(Fornecedor fornecedor)
			throws projetoException {
		controladorFornecedor.atualizarEntities(fornecedor);
	}

	public boolean removerFornecedor(String cpf) throws projetoException {
		return controladorFornecedor.removerEntities(cpf);
	}

	public Fornecedor procurarFornecedor(String cpf) throws projetoException {
		return controladorFornecedor.procurarEntities(cpf);
	}

	public ArrayList<Fornecedor> listarfornecedores() throws projetoException {
		return controladorFornecedor.listarEntities();
	}

}