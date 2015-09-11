package br.aeso.ex01Maurício.exercício.repositorio;

import java.util.ArrayList;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.modelo.ProjectID;

public interface IRepositorio<T extends ProjectID,PK> {

	public abstract void cadastrar(T entity) throws projetoException;

	public abstract T procurar(PK pk) throws projetoException;

	public abstract boolean remover(PK pk)throws projetoException;

	public abstract void atualizar(T entity)throws projetoException;
	
	public abstract ArrayList<T> listarEntities()throws projetoException;

}
