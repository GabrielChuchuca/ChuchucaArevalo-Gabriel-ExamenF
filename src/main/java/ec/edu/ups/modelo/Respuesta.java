/**
 * 
 */
package ec.edu.ups.modelo;

/**
 * @author Gabriel Leonardo Chu
 *
 */
public class Respuesta {
	private String estado;

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Respuesta [estado=" + estado + "]";
	}
}
