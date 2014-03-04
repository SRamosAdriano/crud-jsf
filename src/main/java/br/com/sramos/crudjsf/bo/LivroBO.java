package br.com.sramos.crudjsf.bo;

import java.io.Serializable;
import java.util.List;

import br.com.sramos.crudjsf.exception.BusinessException;
import br.com.sramos.crudjsf.model.Livro;

public interface LivroBO extends Serializable{
	
	public void salvar(Livro livro) throws BusinessException;
	
	public void deletar(Livro livro) throws BusinessException;
	
	public Livro buscarPorId(Long id) throws BusinessException;
	
	public List<Livro> buscarTodos() throws BusinessException;

}
