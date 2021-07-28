/**
 * 
 */
package ec.edu.ups.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Restaurante;

/**
 * @author Gabriel Leonardo Chu
 *
 */
public class Test {
	//protected EntityManagerFactory emf;

	/**
	 * @param args
	 */
	/*public Test() {
		emf = Persistence.createEntityManagerFactory("ChuchucaArevalo-Gabriel-ExamenF");
	}
	public Cliente emp() {
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
		Cliente c1 = new Cliente("0123456789", "Gabriel", "Chuchuca","gchuchuca@gmail.com", "FL", "096937524");
		em.persist(c1);
	    em.getTransaction().commit();
	    em.close();
	    return c1;
		
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Date fe1 = new Date();
		
		//Test t = new Test();
		//Cliente c = t.emp();
		//GregorianCalendar g1 = new GregorianCalendar();
		//System.out.println(fe1);
		//System.out.println(g1);
		
		/*Cliente c1 = new Cliente("0105662068", "Gabriel", "Chuchuca","gchuchuca@gmail.com", "FL", "096937524");
		Restaurante r1 = new Restaurante("KFC","estadio","2854893", 100);
		Reserva re1 = new Reserva(10, new Date(), c1, r1);
		Reserva re2 = new Reserva(5, new Date(), c1, r1);
		List<Reserva> re = new ArrayList<Reserva>();
		re.add(re1);
		re.add(re2);
		Jsonb js = JsonbBuilder.create();*/
		
		//System.out.println(r1);
		//System.out.println(re1.toString());
		///System.out.println(js.toJson(re));
		//0123 4 56 7 89 0 12 3 45
		//2021 - 07 - 29   22 : 20
		
		//dfdfdfdfdd-012345678911234
		//String fh = "2021-07-27 22:20";
		
		
		/*int y = Integer.parseInt(fh.substring(0, 4));
		int me = Integer.parseInt(fh.substring(5, 7));
		int d = Integer.parseInt(fh.substring(8, 10));
		int h = Integer.parseInt(fh.substring(11, 13));
		int mi = Integer.parseInt(fh.substring(14, 16));
		System.out.println(y);
		System.out.println(me);
		System.out.println(d);
		System.out.println(h);
		System.out.println(mi);
		System.out.println("");*/
		
		Calendar fg = new GregorianCalendar();
		/*System.out.println(fg.get(Calendar.YEAR));
		System.out.println(fg.get(Calendar.MONTH));
		System.out.println(fg.get(Calendar.DAY_OF_MONTH));
		System.out.println(fg.get(Calendar.HOUR_OF_DAY));
		System.out.println((fg.get(Calendar.MINUTE))-30);
		System.out.println(fg.get(Calendar.SECOND));
		System.out.println("");*/
		System.out.println(fg);
		
		//System.out.println(y);

	}

}
