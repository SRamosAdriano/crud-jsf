package br.com.sramos.crudjsf.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sramos.crudjsf.bo.AutorBO;
import br.com.sramos.crudjsf.dao.AutorDAO;
import br.com.sramos.crudjsf.exception.BusinessException;
import br.com.sramos.crudjsf.model.Autor;

@Stateless(name="autorBO")
public class AutorBOImpl implements AutorBO{

	private static final long serialVersionUID = -5639472710350264318L;

	@Inject
	AutorDAO autorDAO;
	
	@Override
	public void salvar(Autor autor) throws BusinessException{
		try {
			autorDAO.salvar(autor);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Autor buscarPorId(Long id) throws BusinessException{
		try {
			Autor autor = autorDAO.buscarPorId(id);
			return autor;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Autor> buscarTodos() throws BusinessException{
		try {
			List<Autor> autores = autorDAO.buscarTodos();
			return autores;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Autor> buscarPorIdLivro(Long idLivro) throws BusinessException{
		try {
			List<Autor> autores = autorDAO.buscarPorIdLivro(idLivro);
			return autores;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void excluir(Autor autor) throws BusinessException{
		try {
			autorDAO.excluir(autor);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
}
