package br.com.sramos.crudjsf.bo;

import java.io.Serializable;
import java.util.List;

import br.com.sramos.crudjsf.model.Livro;

public interface LivroBO extends Serializable{
	
	public void salvar(Livro livro);
	
	public void deletar(Livro livro);
	
	public Livro buscarPorId(Long id);
	
	public List<Livro> buscarTodos();

}
