package br.com.sramos.crudjsf.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJPA {

	@PersistenceContext
    private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
