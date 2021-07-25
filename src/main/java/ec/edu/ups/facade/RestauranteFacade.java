/**
 * 
 */
package ec.edu.ups.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
