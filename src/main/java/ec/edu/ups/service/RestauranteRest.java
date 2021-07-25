/**
 * 
 */
package ec.edu.ups.service;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.facade.RestauranteFacade;
import ec.edu.ups.modelo.Respuesta;
import ec.edu.ups.modelo.Restaurante;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Path("/restaurante")
public class RestauranteRest {
	@EJB
	private RestauranteFacade restauranteFacade;
	private Jsonb jsonr;
	
	@POST
	@Path("/registroR")
	//@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ResponseCR(@FormParam("nombre") String nombre,
			@FormParam("direccion") String direccion,
			@FormParam("telefono") String telefono,
			@FormParam("numForo") int numForo) {
		jsonr = JsonbBuilder.create();
		try {
			Restaurante newRestaurante = new Restaurante(nombre, direccion, telefono, numForo);
			restauranteFacade.create(newRestaurante);
			Respuesta res = jsonr.fromJson("{\"estadoCreacion\":\"RESTAURANTE CREADO\"}", Respuesta.class);
			return Response.ok().entity(res).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
		}catch (Exception e) {
			// TODO: handle exception
			Respuesta res = jsonr.fromJson("{\"estadoCreacion\":\"ERROR EN LA CREACION\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
		
	}

}
