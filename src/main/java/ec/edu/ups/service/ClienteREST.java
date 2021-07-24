/**
 * 
 */
package ec.edu.ups.service;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.facade.ClienteFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Respuesta;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Path("/cliente")
public class ClienteREST {
	@EJB
	private ClienteFacade clienteFacade;
	private Jsonb json;
	private Jsonb jsonr;
	

	
			
	@POST
	@Path("/registroC")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ResponseCU(String jsonUsuario) {
		json = JsonbBuilder.create();
		jsonr = JsonbBuilder.create();
		try {
			Cliente newCliente = json.fromJson(jsonUsuario, Cliente.class);
			clienteFacade.create(newCliente);
			Respuesta res = jsonr.fromJson("{\"estadoCreacionUsuario\":\"USUARIO CREADO\"}", Respuesta.class);
			return Response.ok().entity(res).header("Access-Control-Allow-Origin", "*").build();
		}catch (Exception e) {
			// TODO: handle exception
			Respuesta res = jsonr.fromJson("{\"estadoCreacionUsuario\":\"ERROR EN LA CREACION\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").build();
		}
	}
}
