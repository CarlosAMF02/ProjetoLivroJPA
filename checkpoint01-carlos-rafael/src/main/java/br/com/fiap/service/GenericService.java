package br.com.fiap.service;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.fiap.dao.PersistenceManager;
import java.io.Serializable;

public abstract class GenericService<T extends Serializable, PK extends Serializable> {

	private EntityManager entityManager;
	
	public abstract void cadastrar(T entity);
	public abstract void atualizar(T entity);
	public abstract void remover(PK id);
	public abstract T obter(PK id);
	public abstract List<T> listar ();
	
	public EntityManager getEntityManager() {
		if(entityManager == null || !entityManager.isOpen()) {
			entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
		}
		return entityManager;
	}
	
	public void closeEntityManager() {
		if(entityManager != null && entityManager.isOpen()) {
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().commit();
			}
			entityManager.close();
		}
	}
	
}
