/**
 * 
 */
package ec.edu.ups.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Restaurante;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante> {
	@PersistenceContext(unitName = "ChuchucaArevalo-Gabriel-ExamenF")
    private EntityManager em;
	
	public RestauranteFacade() {
		super(Restaurante.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Restaurante findByNameR(String name) {
		try {
    		String jpql = "FROM Restaurante r WHERE r.nombre = ?1";
    		Query query = em.createQuery(jpql);
            query.setParameter(1, name);
            return (Restaurante) query.getSingleResult();
    	}catch (Exception e) {
			// TODO: handle exception
    		//System.out.println("Error: "+e);
            return null;
		}
        
    }

}
