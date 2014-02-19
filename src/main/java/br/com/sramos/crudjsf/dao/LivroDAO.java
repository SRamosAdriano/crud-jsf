package br.com.sramos.crudjsf.dao;

import java.io.Serializable;
import java.util.List;

import br.com.sramos.crudjsf.model.Livro;

public interface LivroDAO extends Serializable{

	public void salvar(Livro livro);
	
	public void deletar(Livro livro);
	
	public Livro buscarPorId(Long id);
	
	public List<Livro> buscarTodos();
	
}
