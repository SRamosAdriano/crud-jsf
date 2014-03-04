package br.com.sramos.crudjsf.dao;

import java.io.Serializable;
import java.util.List;

import br.com.sramos.crudjsf.model.Autor;

public interface AutorDAO extends Serializable{

	public void salvar(Autor autor);
	
	public void excluir(Autor autor);
	
	public Autor buscarPorId(Long id);
	
	public List<Autor> buscarTodos();
	
	public List<Autor> buscarPorIdLivro(Long idLivro);
	
}
