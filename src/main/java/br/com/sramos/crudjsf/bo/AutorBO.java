package br.com.sramos.crudjsf.bo;

import java.io.Serializable;
import java.util.List;

import br.com.sramos.crudjsf.exception.BusinessException;
import br.com.sramos.crudjsf.model.Autor;

public interface AutorBO extends Serializable{
	
	public void salvar(Autor autor) throws BusinessException;
	
	public void excluir(Autor autor) throws BusinessException;
	
	public Autor buscarPorId(Long id) throws BusinessException;
	
	public List<Autor> buscarTodos() throws BusinessException;
	
	public List<Autor> buscarPorIdLivro(Long idLivro) throws BusinessException;

}
