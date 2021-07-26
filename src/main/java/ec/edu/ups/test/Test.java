/**
 * 
 */
package ec.edu.ups.test;

import java.util.Date;
import java.util.GregorianCalendar;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Restaurante;

/**
 * @author Gabriel Leonardo Chu
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Date fe1 = new Date();
		//GregorianCalendar g1 = new GregorianCalendar();
		//System.out.println(fe1);
		//System.out.println(g1);
		
		Cliente c1 = new Cliente("0105662068", "Gabriel Chuchuca","gchuchuca@gmail.com", "FL", "096937524");
		Restaurante r1 = new Restaurante("mcdonalds","estadio","2854893", 100);
		Reserva re1 = new Reserva(10, new Date(), c1, r1);
		
		System.out.println(c1);
		System.out.println(r1);
		System.out.println(re1.toString());

	}

}
