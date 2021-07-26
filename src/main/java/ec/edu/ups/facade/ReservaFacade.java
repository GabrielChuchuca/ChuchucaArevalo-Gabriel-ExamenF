/**
 * 
 */
package ec.edu.ups.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Restaurante;

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
	
	public List<Reserva> getReservaxC(String ced){
		try {
			//from public.reserva r where r.cedula_cliente ='0105662068'
    		String jpql = "FROM Reserva r WHERE r.cedula_cliente = '"+ced+"'";
            return (List<Reserva>) em.createQuery(jpql).getResultList();
    	}catch (Exception e) {
			// TODO: handle exception
    		//System.out.println("Error: "+e)
    		return null;
            //return null;
		}
	}
}
