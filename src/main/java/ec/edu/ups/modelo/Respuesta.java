/**
 * 
 */
package ec.edu.ups.modelo;

/**
 * @author Gabriel Leonardo Chu
 *
 */
public class Respuesta {
	private String estadoCreacionUsuario;

	/**
	 * @return the estadoCreacionUsuario
	 */
	public String getEstadoCreacionUsuario() {
		return estadoCreacionUsuario;
	}

	/**
	 * @param estadoCreacionUsuario the estadoCreacionUsuario to set
	 */
	public void setEstadoCreacionUsuario(String estadoCreacionUsuario) {
		this.estadoCreacionUsuario = estadoCreacionUsuario;
	}

	@Override
	public String toString() {
		return "Respuesta [estadoCreacionUsuario=" + estadoCreacionUsuario + "]";
	}
	
	

}
