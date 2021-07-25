/**
 * 
 */
package ec.edu.ups.modelo;

/**
 * @author Gabriel Leonardo Chu
 *
 */
public class Respuesta {
	private String estadoCreacion;

	/**
	 * @return the estadoCreacionUsuario
	 */
	public String getEstadoCreacion() {
		return estadoCreacion;
	}

	/**
	 * @param estadoCreacionUsuario the estadoCreacionUsuario to set
	 */
	public void setEstadoCreacion(String estadoCreacion) {
		this.estadoCreacion = estadoCreacion;
	}

	@Override
	public String toString() {
		return "Respuesta [estadoCreacion=" + estadoCreacion + "]";
	}
	
	

}
