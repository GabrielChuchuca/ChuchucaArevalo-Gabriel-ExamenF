/**
 * 
 */
package ec.edu.ups.service;

import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
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
	//private Jsonb json;
	private Jsonb jsonr;
	
	@POST
	@Path("/registroC")
	//@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	//public Response ResponseCU(String jsonUsuario) {
	public Response ResponseCU(@FormParam("cedula") String cedula, 
			@FormParam("nombres") String nombres, 
			@FormParam("apellidos") String apellidos,
			@FormParam("correo") String correo, 
			@FormParam("direccion") String direccion, 
			@FormParam("telefono") String telefono) {
		
		//json = JsonbBuilder.create();
		jsonr = JsonbBuilder.create();
		try {
			Cliente newCliente = new Cliente(cedula, nombres, apellidos, correo, direccion, telefono);
			//Cliente newCliente = json.fromJson(jsonUsuario, Cliente.class);
			clienteFacade.create(newCliente);
			Respuesta res = jsonr.fromJson("{\"estado\":\"USUARIO CREADO\"}", Respuesta.class);
			return Response.ok().entity(res).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
		}catch (Exception e) {
			// TODO: handle exception
			Respuesta res = jsonr.fromJson("{\"estado\":\"ERROR EN LA CREACION\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
	
	@POST
	@Path("/clienteFind")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getC(@FormParam("cedula") String cedula) {
		if (cedula != "") {
			Jsonb jsonb = JsonbBuilder.create();
			
			try {
				Cliente cli = clienteFacade.find(cedula);
				return  Response.ok(jsonb.toJson(cli)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
				
			}catch (Exception e) {
				// TODO: handle exception
				Respuesta res = jsonr.fromJson("{\"estado\":\"USUARIO NO ENCONTRADO\"}", Respuesta.class);
				return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			}
		}else {
			Respuesta res = jsonr.fromJson("{\"estado\":\"CEDULA INSUFICIENTE\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
	
	@GET
	@Path("/clienteBAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllC() {
		Jsonb jsonb = JsonbBuilder.create();
		try {
			List<Cliente> clie = clienteFacade.findAll();
			return Response.ok(jsonb.toJson(clie)).header("Access-Control-Allow-Origin", "*").build();
		}catch (Exception e) {
			// TODO: handle exception
			Respuesta res = jsonr.fromJson("{\"estado\":\"NO HAY CLIENTES\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			
		}
	}
	
}
