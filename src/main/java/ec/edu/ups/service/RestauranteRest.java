/**
 * 
 */
package ec.edu.ups.service;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
public class RestauranteREST {
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
			@FormParam("numAforo") int numAforo) {
		jsonr = JsonbBuilder.create();
		try {
			Restaurante newRestaurante = new Restaurante(nombre, direccion, telefono, numAforo);
			restauranteFacade.create(newRestaurante);
			Respuesta res = jsonr.fromJson("{\"estado\":\"RESTAURANTE CREADO\"}", Respuesta.class);
			return Response.ok().entity(res).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
		}catch (Exception e) {
			// TODO: handle exception
			Respuesta res = jsonr.fromJson("{\"estado\":\"ERROR EN LA CREACION\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
	
	@POST
	@Path("/restauranteB")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRe(@FormParam("nombre") String nombre) {
		if (nombre != "") {
			Jsonb jsonb = JsonbBuilder.create();
			try {
				Restaurante rest = restauranteFacade.findByNameR(nombre);
				return  Response.ok(jsonb.toJson(rest)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
				
			}catch (Exception e) {
				// TODO: handle exception
				Respuesta res = jsonr.fromJson("{\"estado\":\"RESTAURANTE NO ENCONTRADO\"}", Respuesta.class);
				return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			}
		}else {
			Respuesta res = jsonr.fromJson("{\"estado\":\"DATOS INSUFICIENTE\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
		
	}
	
	@Path("/actualizarForo")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarA(@FormParam("nombre") String nombre, @FormParam("numP") Integer numP) {
		if (nombre != "") {
			Jsonb jsonb = JsonbBuilder.create();
			try {
				Restaurante rest = restauranteFacade.findByNameR(nombre);
				rest.setNumAforo(rest.getNumAforo() - numP);
				restauranteFacade.edit(rest);
				Respuesta res = jsonr.fromJson("{\"estado\":\"NUMERO DE AFORO ACTUALIZADO\"}", Respuesta.class);
				//Respuesta res = jsonr.fromJson(rest, Restaurante.class);
				return Response.ok().entity(res).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
			} catch (Exception e) {
				// TODO: handle exception
				Respuesta res = jsonr.fromJson("{\"estado\":\"ERROR EN LA ACTUALIZACION\"}", Respuesta.class);
				return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			}
		}else {
			Respuesta res = jsonr.fromJson("{\"estado\":\"ERROR\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
}
