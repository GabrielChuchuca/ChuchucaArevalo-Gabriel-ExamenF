/**
 * 
 */
package ec.edu.ups.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.facade.ClienteFacade;
import ec.edu.ups.facade.ReservaFacade;
import ec.edu.ups.facade.RestauranteFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Respuesta;
import ec.edu.ups.modelo.Restaurante;

/**
 * @author Gabriel Leonardo Chu
 *
 */
@Path("/reserva")
public class ReservaREST {
	@EJB
	private ReservaFacade reservaFacade;
	
	@EJB
	private ClienteFacade clienteFacade;
	
	@EJB
	private RestauranteFacade restauranteFacade;
	
	private List<Reserva> reservas;
	private List<Cliente> clientes;
	private List<Restaurante> restaurantes;
	
	private Jsonb jsonr;
	
	@POST
	@Path("/registroRa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registroRa(@FormParam("cedula") String cedula, @FormParam("nombreR") String nombreR, @FormParam("fh") String fh, @FormParam("numP") Integer numP) {
		if (cedula != "" && nombreR != "") {
			jsonr = JsonbBuilder.create();
			try {
				
				Cliente cli = clienteFacade.find(cedula);
				Restaurante rest = restauranteFacade.findByNameR(nombreR);
				
				int y = Integer.parseInt(fh.substring(0, 4));
				int me = Integer.parseInt(fh.substring(5, 7));
				int d = Integer.parseInt(fh.substring(8, 10));
				int h = Integer.parseInt(fh.substring(11, 13));
				int mi = Integer.parseInt(fh.substring(14, 16));

				Calendar fg = new GregorianCalendar(y, me, d, h, mi, 0);
				Reserva rese = new Reserva(numP, fg, cli, rest);
				reservaFacade.create(rese);
				rest.setNumAforo(rest.getNumAforo() - numP);
				restauranteFacade.edit(rest);
				Respuesta res = jsonr.fromJson("{\"estado\":\"RESERVA CREADA\"}", Respuesta.class);
				return Response.ok().entity(res).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-Type").header("Access-Control-Allow-Methods", "*").build();
				
			}catch (Exception e) {
				// TODO: handle exception
				Respuesta res = jsonr.fromJson("{\"estado\":\"ERROR EN LA CREACION\"}", Respuesta.class);
				return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			}			
		}else {
			Respuesta res = jsonr.fromJson("{\"estado\":\"ERROR EN LA CREACION\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
	
	@GET
	@Path("/listarRaxC/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRaxC(@PathParam("cedula") String cedula) {
		if (cedula != "") {
			try {
				Jsonb jsonb = JsonbBuilder.create();
				reservas = reservaFacade.getReservaxC(cedula);
				if (reservas!=null) {
					//rese = reservaFacade.getReservaxC(cedula);
					return Response.ok(jsonb.toJson(reservas)).header("Access-Control-Allow-Origin", "*").build();
				}else {
					Respuesta res = jsonr.fromJson("{\"estado\":\"valor null\"}", Respuesta.class);
					return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
				}
			} catch (Exception e) {
				// TODO: handle exception
				Respuesta res = jsonr.fromJson("{\"estado\":\"NO HAY RESERVAS CON ESTA CEDULA\"}", Respuesta.class);
				return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			}
		}else {
			Respuesta res = jsonr.fromJson("{\"estado\":\"DATOS INSUFICIENTE\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRa(@PathParam("id") Integer id) {
		if (id != null) {
			try {
				Jsonb jsonb = JsonbBuilder.create();
				Reserva rese = reservaFacade.find(id);
				return Response.ok(jsonb.toJson(rese)).header("Access-Control-Allow-Origin", "*").build();
			}catch (Exception e) {
				// TODO: handle exception
				Respuesta res = jsonr.fromJson("{\"estado\":\"RESERVA NO ENCONTRADA\"}", Respuesta.class);
				return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
			}
		}else {
			Respuesta res = jsonr.fromJson("{\"estado\":\"DATOS INSUFICIENTE\"}", Respuesta.class);
			return Response.status(500).entity(res).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "*").build();
		}
	}
	
	@GET
	@Path("/listarRa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gettRa() {
		Jsonb jsonb = JsonbBuilder.create();
		reservas = reservaFacade.findAll();
		return Response.ok(jsonb.toJson(reservas)).header("Access-Control-Allow-Origin", "*").build();
		
	}
	
}
