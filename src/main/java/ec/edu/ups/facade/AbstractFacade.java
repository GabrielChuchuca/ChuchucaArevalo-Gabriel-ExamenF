/**
 * 
 */
package ec.edu.ups.facade;

import javax.persistence.EntityManager;

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

}
