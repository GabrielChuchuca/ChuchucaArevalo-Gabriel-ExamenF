/**
 * 
 */
package ec.edu.ups.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Reserva;

/**
 * @author Gabriel Leonardo Chu
 *
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva>{
	@PersistenceContext(unitName = "ChuchucaArevalo-Gabriel-ExamenF")
    private EntityManager em;
	
	public ReservaFacade() {
		super(Reserva.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
