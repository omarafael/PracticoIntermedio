package servicio;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import configuracion.DBConfig;
import modelo.Cliente;
import modelo.Incidente;
import modelo.Servicio;
import modelo.Tecnico;
import modelo.TipoDeProblema;



public class Main {

	public static void main(String[] args) {
	
		Cliente cliente1 = new Cliente("4","2","3","4","5",true);
		Cliente cliente2 = new Cliente("5","1","1","4","5",true);
		Servicio servicio2 = new Servicio("2",1,true);
		Servicio servicio3 = new Servicio("2",1,true);
		Servicio servicio4 = new Servicio("2",1,true);
		
		
		cliente1.agregarServicio(servicio2);
		cliente1.agregarServicio(servicio3);
		cliente1.agregarServicio(servicio4);
		cliente2.agregarServicio(servicio2);

		Tecnico tecnico1 = new Tecnico ("123", "Juan", "Perez", "0303456", "juan@gmail.com",
				"mail");
		Tecnico tecnico2 = new Tecnico ("124", "Pedro", "Perez", "0303654", "pedro@gmail.com",
				"whatsapp");
		tecnico1.agregarEspecialidad(servicio2);
		tecnico2.agregarEspecialidad(servicio4);
		
		TipoDeProblema tipo1 = new TipoDeProblema ("No Imprime", 2);
		
		
		servicio4.agregarTipoDeProblema(tipo1);
		
		tecnico1.agregarTipoDeProblema(tipo1);
		tecnico2.agregarTipoDeProblema(tipo1);
		
		LocalDate fechaActual = LocalDate.now();
		Incidente incidente1 = new Incidente (cliente1, servicio4,"descripcionDeProblema", fechaActual );
		incidente1.setTecnico(tecnico2);
		
		EntityManager em = DBConfig.getEntityManager();
		
		
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(tipo1);
		tx.commit();
		
		
		tx.begin();
			em.persist(servicio2);
			em.persist(servicio3);
			em.persist(servicio4);
			tx.commit();
		
		tx.begin();
		em.persist(tecnico2);
		em.persist(tecnico1);
		tx.commit();
		
		tx.begin();
		em.persist(cliente1);
		em.persist(cliente2);
		tx.commit();
		
		tx.begin();
		em.persist(incidente1);
		tx.commit();
	
	}
	
	

}
