package br.com.sramos.crudjsf.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sramos.crudjsf.dao.AutorDAO;
import br.com.sramos.crudjsf.model.Autor;

@Named("autorDAO")
public class AutorJPA extends AbstractJPA implements AutorDAO {

	private static final long serialVersionUID = -7484164201650703925L;
	
	@Override
	public void salvar(Autor autor) {
		if(autor.getId() == null){
			getEntityManager().persist(autor);
		}else{
			getEntityManager().merge(autor);
		}
	}

	@Override
	public Autor buscarPorId(Long id) {
		String jpql = "select a from Autor a where id = :id";
		Query query = getEntityManager().createQuery(jpql, Autor.class);
		query.setParameter("id", id);
		Autor autor = (Autor) query.getSingleResult();
		return autor;
	}

	@Override
	public List<Autor> buscarTodos() {
		String jpql = "select a from Autor a order by a.nome";
		TypedQuery<Autor> query = getEntityManager().createQuery(jpql, Autor.class);
		List<Autor> autores = query.getResultList();
		return autores;
	}

	@Override
	public List<Autor> buscarPorIdLivro(Long idLivro) {
		String jpql = "select a from Autor a join fetch a.livros l where l.id = :idLivro order by a.nome";
		TypedQuery<Autor> query = getEntityManager().createQuery(jpql, Autor.class);
		query.setParameter("idLivro", idLivro);
		List<Autor> autores = query.getResultList();
		return autores;
	}

	@Override
	public void excluir(Autor autor) {
		getEntityManager().remove(getEntityManager().getReference(Autor.class, autor.getId()));
	}
}
