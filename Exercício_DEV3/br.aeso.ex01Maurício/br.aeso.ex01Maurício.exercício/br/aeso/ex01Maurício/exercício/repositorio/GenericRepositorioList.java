package br.aeso.ex01Maurício.exercício.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.modelo.ProjectID;

public class GenericRepositorioList<T extends ProjectID> implements
		IRepositorio<T,String> {

	List<T> entities;

	public GenericRepositorioList() {
		entities = new ArrayList<T>();
	}

	@Override
	public void cadastrar(T entity) throws projetoException {
		/*if (this.procurar(entity.getID()) == null) {
			entities.add(entity);
		} else
			throw new projetoException("Entidade já existente!");*/
	}

	@Override
	public T procurar(String cpf) {
		T entidadeEncontrada = null;
		for (T i : entities) {
			if (i.getID().equals(cpf)) {
				entidadeEncontrada = i;
			}
		}
		return entidadeEncontrada;
	}

	@Override
	public boolean remover(String cpf) throws projetoException {
		if (this.procurar(cpf) != null) {
			entities.remove(this.procurar(cpf));
			return true;
		} else {
			throw new projetoException("Entidade não existente!");
		}
	}

	@Override
	public void atualizar(T entity) throws projetoException {
		/*if (this.procurar(entity.getID()) != null) {
			entities.remove(this.procurar(entity.getID()));
			entities.add(entity);
		} else {
			throw new projetoException("Entidade já existente!");
		}*/
	}

	@Override
	public ArrayList<T> listarEntities() {
		ArrayList<T> entidades = new ArrayList<T>();
		for (T i : entities) {
			entidades.add(i);
		}
		return entidades;
	}

}
