package br.com.sramos.crudjsf.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sramos.crudjsf.bo.LivroBO;
import br.com.sramos.crudjsf.dao.LivroDAO;
import br.com.sramos.crudjsf.model.Livro;

@Stateless(name="livroBO")
public class LivroBOImpl implements LivroBO{

	private static final long serialVersionUID = -5639472710350264318L;

	@Inject
	LivroDAO livroDAO;
	
	@Override
	public void salvar(Livro livro) {
		livroDAO.salvar(livro);
	}

	@Override
	public void deletar(Livro livro) {
		livro.setAtivo(false);
		livroDAO.deletar(livro);
		
	}

	@Override
	public Livro buscarPorId(Long id) {
		Livro livro = livroDAO.buscarPorId(id);
		return livro;
	}

	@Override
	public List<Livro> buscarTodos() {
		List<Livro> livros = livroDAO.buscarTodos();
		return livros;
	}

}
