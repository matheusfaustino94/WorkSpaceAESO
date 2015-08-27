package br.aeso.ex01Maurício.exercício.controlador;

import java.util.ArrayList;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.modelo.ProjectID;

public interface IControlador<T extends ProjectID> {

	public abstract void cadastrarEntities(T entity) throws projetoException;

	public abstract void atualizarEntities(T entity) throws projetoException;

	public abstract T procurarEntities(String id) throws projetoException;

	public abstract ArrayList<T> listarEntities() throws projetoException;

	public abstract boolean removerEntities(String id) throws projetoException;

}