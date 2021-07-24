/**
 * 
 */
package ec.edu.ups.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
