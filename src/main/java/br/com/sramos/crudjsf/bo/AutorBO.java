package br.com.sramos.crudjsf.bo;

import java.io.Serializable;
import java.util.List;

import br.com.sramos.crudjsf.model.Autor;

public interface AutorBO extends Serializable{
	
	public void salvar(Autor autor);
	
	public Autor buscarPorId(Long id);
	
	public List<Autor> buscarTodos();

}
