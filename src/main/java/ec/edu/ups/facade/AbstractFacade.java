/**
 * 
 */
package ec.edu.ups.facade;

import java.util.List;

import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Restaurante;

/**
 * @author Gabriel Leonardo Chu
 *
 */
public abstract class AbstractFacade<T> {
	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public void create(T entity) {
		System.out.println("Metodo Crear Entidad...");
		getEntityManager().persist(entity);
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	
	public void edit(T entity) {
		getEntityManager().merge(entity);
	}

	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	/*
	 * public T findByName(String name) { String jpql =
	 * "FROM Bodega b WHERE b.nombre = '" + name + "';"; Object obj =
	 * getEntityManager().createQuery(jpql).getResultList()
	 * //System.out.println("Lista================================== " +
	 * em.createQuery(jpql).getResultList()); return obj; }
	 */

}
