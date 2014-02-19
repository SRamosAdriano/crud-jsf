package br.com.sramos.crudjsf.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sramos.crudjsf.dao.LivroDAO;
import br.com.sramos.crudjsf.model.Livro;

@Named("livroDAO")
public class LivroJPA implements LivroDAO {

    @PersistenceContext
    private EntityManager entityManager;
	
	private static final long serialVersionUID = -6688555651331649556L;

	@Override
	public void salvar(Livro livro) {
		if(livro.getId() == null){
			entityManager.persist(livro);
		}else{
			entityManager.merge(livro);
		}
	}

	@Override
	public void deletar(Livro livro) {
		entityManager.merge(livro);
	}

	@Override
	public Livro buscarPorId(Long id) {
		String jpql = "select l from Livro l where id = :id";
		Query query = entityManager.createQuery(jpql, Livro.class);
		query.setParameter("id", id);
		Livro livro = (Livro) query.getSingleResult();
		return livro;
	}

	@Override
	public List<Livro> buscarTodos() {
		String jpql = "select l from Livro l order by nome";
		TypedQuery<Livro> query = entityManager.createQuery(jpql, Livro.class);
		List<Livro> livros = query.getResultList();
		return livros;
	}
}
