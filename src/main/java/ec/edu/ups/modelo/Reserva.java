package ec.edu.ups.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private int id;
	
	private int numPersonas;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraReserva;
	
	@ManyToOne
	@JoinColumn(name="cedula_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_restaurante")
	private Restaurante restaurante;
	
	public Reserva() {
	}

	public Reserva(int numPersonas, Date fechaHoraReserva, Cliente cliente, Restaurante restaurante) {
		super();
		this.numPersonas = numPersonas;
		this.fechaHoraReserva = fechaHoraReserva;
		this.cliente = cliente;
		this.restaurante = restaurante;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numPersonas
	 */
	public int getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas the numPersonas to set
	 */
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the fechaHoraReserva
	 */
	public Date getFechaHoraReserva() {
		return fechaHoraReserva;
	}

	/**
	 * @param fechaHoraReserva the fechaHoraReserva to set
	 */
	public void setFechaHoraReserva(Date fechaHoraReserva) {
		this.fechaHoraReserva = fechaHoraReserva;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the restaurante
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fechaHoraReserva == null) ? 0 : fechaHoraReserva.hashCode());
		result = prime * result + id;
		result = prime * result + numPersonas;
		result = prime * result + ((restaurante == null) ? 0 : restaurante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fechaHoraReserva == null) {
			if (other.fechaHoraReserva != null)
				return false;
		} else if (!fechaHoraReserva.equals(other.fechaHoraReserva))
			return false;
		if (id != other.id)
			return false;
		if (numPersonas != other.numPersonas)
			return false;
		if (restaurante == null) {
			if (other.restaurante != null)
				return false;
		} else if (!restaurante.equals(other.restaurante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", numPersonas=" + numPersonas + ", fechaHoraReserva=" + fechaHoraReserva
				+ ", cliente=" + cliente + ", restaurante=" + restaurante + "]";
	}
}