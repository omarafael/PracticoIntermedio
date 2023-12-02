package servicio;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import configuracion.DBConfig;
import modelo.Cliente;
import modelo.Incidente;
import modelo.ProvisionDeServicio;
import modelo.Servicio;
import modelo.Tecnico;
import modelo.TipoDeProblema;



public class Main {

	public static void main(String[] args) {
	
		Cliente cliente1 = new Cliente("20123456780","Quimica Belgrano","junin 123","2664123456","quimica@gmail.com",true);
		Cliente cliente2 = new Cliente("21123256789","Farmacia San Martin","Lavalle 332","2664233476","farmacia@gmail.com",true);
		Cliente cliente3 = new Cliente("21323235789","Carniceria Guemes","Colon 532","2664535496","carniceria@gmail.com",true);
		Cliente cliente4 = new Cliente("27723246781","kiosco Sarmiento","Rivadavia 732","2665272476","kiosco@gmail.com",true);
		
		Servicio servicio1 = new Servicio("linux",1,true);
		Servicio servicio2 = new Servicio("windows",2,true);
		Servicio servicio3 = new Servicio("sap",4,true);
		Servicio servicio4 = new Servicio("tango",3,true);
		
		
		cliente1.agregarServicio(servicio2);
		cliente1.agregarServicio(servicio3);
		cliente1.agregarServicio(servicio4);
		cliente2.agregarServicio(servicio2);
		
		ProvisionDeServicio provision1 = new ProvisionDeServicio(servicio1, cliente1, true, LocalDate.of(2020, 10, 10) );
		ProvisionDeServicio provision2 = new ProvisionDeServicio(servicio2, cliente2, true, LocalDate.of(2020, 4, 13) );
		ProvisionDeServicio provision3 = new ProvisionDeServicio(servicio3, cliente1, true, LocalDate.of(2020, 9, 11) );
		ProvisionDeServicio provision4 = new ProvisionDeServicio(servicio4, cliente4, true, LocalDate.of(2020, 2, 13) );

		Tecnico tecnico1 = new Tecnico ("34666123", "Juan", "Perez", "0303456", "juan@gmail.com",
				"mail");
		Tecnico tecnico2 = new Tecnico ("21124456", "Pedro", "Martinez", "0303434", "pedro@gmail.com",
				"whatsapp");
		Tecnico tecnico3 = new Tecnico ("23943123", "Luis", "Fernandez", "03233456", "luis@gmail.com",
				"mail");
		Tecnico tecnico4 = new Tecnico ("24123333", "Jaime", "Lopez", "13203456", "jaime@gmail.com",
				"mail");
		
		tecnico1.agregarEspecialidad(servicio1);
		tecnico2.agregarEspecialidad(servicio2);
		tecnico3.agregarEspecialidad(servicio3);
		tecnico4.agregarEspecialidad(servicio4);
		tecnico2.agregarEspecialidad(servicio4);
		tecnico3.agregarEspecialidad(servicio1);
		tecnico1.agregarEspecialidad(servicio4);
		
		TipoDeProblema tipo1 = new TipoDeProblema ("Actualizacion", 8);
		TipoDeProblema tipo2 = new TipoDeProblema ("Instalacion", 2);
		TipoDeProblema tipo3 = new TipoDeProblema ("Conectividad", 3);
		TipoDeProblema tipo4= new TipoDeProblema ("Configuracion", 6);
		
		servicio1.agregarTipoDeProblema(tipo1);
		servicio2.agregarTipoDeProblema(tipo2);
		servicio3.agregarTipoDeProblema(tipo3);
		servicio4.agregarTipoDeProblema(tipo4);
		servicio1.agregarTipoDeProblema(tipo2);
		servicio2.agregarTipoDeProblema(tipo3);
		servicio3.agregarTipoDeProblema(tipo4);
		servicio4.agregarTipoDeProblema(tipo1);
		servicio1.agregarTipoDeProblema(tipo3);
		servicio2.agregarTipoDeProblema(tipo4);
		servicio3.agregarTipoDeProblema(tipo1);
		servicio4.agregarTipoDeProblema(tipo2);
		
		tecnico1.agregarTipoDeProblema(tipo1);
		tecnico2.agregarTipoDeProblema(tipo2);
		tecnico3.agregarTipoDeProblema(tipo3);
		tecnico4.agregarTipoDeProblema(tipo4);
		tecnico1.agregarTipoDeProblema(tipo2);
		tecnico2.agregarTipoDeProblema(tipo3);
		tecnico3.agregarTipoDeProblema(tipo4);
		tecnico4.agregarTipoDeProblema(tipo1);
		
		LocalDate fechaActual = LocalDate.now();
		Incidente incidente1 = new Incidente (cliente1, servicio1,"descripcionDeProblema1", LocalDate.of(2020, 10, 13) );
		
		Incidente incidente2 = new Incidente (cliente2, servicio2,"descripcionDeProblema2", LocalDate.of(2023, 11, 14) );
		
		Incidente incidente3 = new Incidente (cliente3, servicio3,"descripcionDeProblema3", LocalDate.of(2023, 9, 30) );
		
		Incidente incidente4 = new Incidente (cliente4, servicio4,"descripcionDeProblema4", LocalDate.of(2023, 7, 15) );
		
		Incidente incidente5 = new Incidente (cliente1, servicio4,"descripcionDeProblema4", LocalDate.of(2023, 5, 17) );
		
		Incidente incidente6 = new Incidente (cliente2, servicio3,"descripcionDeProblema3", LocalDate.of(2023, 3, 23) );
		
		Incidente incidente7 = new Incidente (cliente3, servicio2,"descripcionDeProblema2", LocalDate.of(2023, 6, 27) );
		
		Incidente incidente8 = new Incidente (cliente4, servicio1,"descripcionDeProblema1", LocalDate.of(2023, 8, 20) );
		
		
		incidente1.setTecnico(tecnico1);
		incidente2.setTecnico(tecnico2);
		incidente3.setTecnico(tecnico3);
		incidente4.setTecnico(tecnico4);
		incidente5.setTecnico(tecnico1);
		incidente6.setTecnico(tecnico2);
		incidente7.setTecnico(tecnico3);
		incidente8.setTecnico(tecnico4);
		
		incidente1.agregarTipoDeProblema(tipo1);
		incidente2.agregarTipoDeProblema(tipo2);
		incidente3.agregarTipoDeProblema(tipo3);
		incidente4.agregarTipoDeProblema(tipo4);
		incidente5.agregarTipoDeProblema(tipo1);
		incidente6.agregarTipoDeProblema(tipo2);
		incidente7.agregarTipoDeProblema(tipo3);
		incidente8.agregarTipoDeProblema(tipo4);
		incidente1.agregarTipoDeProblema(tipo2);
		incidente2.agregarTipoDeProblema(tipo3);
		incidente3.agregarTipoDeProblema(tipo4);
		
		
		
		
		
		
		EntityManager em = DBConfig.getEntityManager();
		
		
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(tipo1);
		em.persist(tipo2);
		em.persist(tipo3);
		em.persist(tipo4);
		
		tx.commit();
		
		
		tx.begin();
		    em.persist(servicio1);
			em.persist(servicio2);
			em.persist(servicio3);
			em.persist(servicio4);
			tx.commit();
		
		tx.begin();
		em.persist(tecnico1);
		em.persist(tecnico2);
		em.persist(tecnico3);
		em.persist(tecnico4);
		tx.commit();
		
		tx.begin();
		em.persist(cliente1);
		em.persist(cliente2);
		em.persist(cliente3);
		em.persist(cliente4);
		tx.commit();
		
		tx.begin();
		em.persist(incidente1);
		em.persist(incidente2);
		em.persist(incidente3);
		em.persist(incidente4);
		em.persist(incidente5);
		em.persist(incidente6);
		em.persist(incidente7);
		em.persist(incidente8);
		tx.commit();
	
		tx.begin();
		em.persist(provision1);
		em.persist(provision2);
		em.persist(provision3);
		em.persist(provision4);
		tx.commit();
	}
	
	

}
