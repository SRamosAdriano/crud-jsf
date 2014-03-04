package br.com.sramos.crudjsf.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sramos.crudjsf.bo.AutorBO;
import br.com.sramos.crudjsf.dao.AutorDAO;
import br.com.sramos.crudjsf.model.Autor;

@Stateless(name="autorBO")
public class AutorBOImpl implements AutorBO{

	private static final long serialVersionUID = -5639472710350264318L;

	@Inject
	AutorDAO autorDAO;
	
	@Override
	public void salvar(Autor autor) {
		autorDAO.salvar(autor);
	}

	@Override
	public Autor buscarPorId(Long id) {
		Autor autor = autorDAO.buscarPorId(id);
		return autor;
	}

	@Override
	public List<Autor> buscarTodos() {
		List<Autor> autores = autorDAO.buscarTodos();
		return autores;
	}

	@Override
	public List<Autor> buscarPorIdLivro(Long idLivro) {
		List<Autor> autores = autorDAO.buscarPorIdLivro(idLivro);
		return autores;
	}

	@Override
	public void excluir(Autor autor) {
		autorDAO.excluir(autor);
	}

}
