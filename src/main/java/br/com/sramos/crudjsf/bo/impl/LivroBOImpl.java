package br.com.sramos.crudjsf.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sramos.crudjsf.bo.LivroBO;
import br.com.sramos.crudjsf.dao.LivroDAO;
import br.com.sramos.crudjsf.exception.BusinessException;
import br.com.sramos.crudjsf.model.Livro;

@Stateless(name="livroBO")
public class LivroBOImpl implements LivroBO{

	private static final long serialVersionUID = -5639472710350264318L;

	@Inject
	LivroDAO livroDAO;
	
	@Override
	public void salvar(Livro livro) throws BusinessException{
		try {
			livroDAO.salvar(livro);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(Livro livro) throws BusinessException{
		try {
			livro.setAtivo(false);
			livroDAO.deletar(livro);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Livro buscarPorId(Long id) throws BusinessException{
		try {
			Livro livro = livroDAO.buscarPorId(id);
			return livro;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Livro> buscarTodos() throws BusinessException{
		try {
			List<Livro> livros = livroDAO.buscarTodos();
			return livros;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
}
