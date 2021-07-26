/**
 * 
 */
package ec.edu.ups.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.StaticMetamodel;

import ec.edu.ups.modelo.Cliente;


/**
 * @author Gabriel Leonardo Chu
 *
 */

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
	@PersistenceContext(unitName = "ChuchucaArevalo-Gabriel-ExamenF")
    private EntityManager em;

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
   
    public Cliente findByNameFull(String name)
    {
    	try {
    		String jpql = "FROM Cliente c WHERE c.nombres = ?1";
    		Query query = em.createQuery(jpql);
    		query.setParameter(1, name);
            return (Cliente) query.getSingleResult();
    	}catch (Exception e) {
			// TODO: handle exception
    		//System.out.println("Error: "+e);
            return null;
		}
    	
    }

}
