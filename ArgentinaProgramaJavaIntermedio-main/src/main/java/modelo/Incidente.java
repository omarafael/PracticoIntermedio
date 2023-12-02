package modelo;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import DAO.TecnicoDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name="incidente")
@NoArgsConstructor
@Getter @Setter
public class Incidente implements Serializable {
	@Id
	@Column	(name="idIncidente")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idIncidente;
	@ManyToOne	
	private Cliente cliente;
	@ManyToOne	
	private Servicio servicio;
	@ManyToMany
	private List<TipoDeProblema> tiposDeProblemas;
	@Column	(name="descripcionDeProblema")
	private String descripcionDeProblema;
	@ManyToOne
	private Tecnico tecnicoAsignado;
	@Column	(name="hsAdicionalesComplejo")
	private int hsAdicionalesComplejo;
	@Column	(name="fechaEstimadaDeResolucion")
	private LocalDate fechaEstimadaDeResolucion;
	@Column	(name="fechaIncidente")
	private LocalDate fechaIncidente;
	@Column	(name="fechaFinIncidente")
	private Date fechaFinIncidente;
	@Column	(name="activo")
	private boolean activo=true;
	@Column	(name="estado")
	private Estado estado = Estado.INICIADO;
	
	public Incidente( Cliente cliente, Servicio servicio, 
			String descripcionDeProblema,
			LocalDate fechaIncidente) {
		
		this.cliente = cliente;
		this.servicio = servicio;
		this.descripcionDeProblema = descripcionDeProblema;
		this.fechaIncidente = fechaIncidente;
		tiposDeProblemas = new ArrayList<TipoDeProblema>();
	}
	
	public void bajaIncidente() {
		this.activo = false;
	}
	
	public void agregarTipoDeProblema(TipoDeProblema tipoDeProblema) {
		tiposDeProblemas.add(tipoDeProblema);
	}
	 
	public List tiposDeProblemas () {
		return tiposDeProblemas;
	}
	
	public void setTecnico (Tecnico tecnico) {
		this.tecnicoAsignado = tecnico;
	}
	
	
		
		
	
    public void buscarTecnicosDisponibles(Servicio especialidad) {
	
	TecnicoDAO tecnicoDAO = new TecnicoDAO();
	
	
	List<Tecnico> listaTecnicosDisponibles = tecnicoDAO.findAll();
	for (Tecnico tecnico : listaTecnicosDisponibles) {
	//	System.out.println(tecnico.getNombre);
	//listaTecnicosDisponibles.stream().anyMatch((tecnico)-> tecnico.especialidades.stream().anyMatch ((especialidadTecnico)-> especialidadTecnico.equals(especialidad)))
	//listaTecnicosDisponibles
	
	//listaTecnicoDisponible.stream().forEach((tecnico) -> System.out.println(tecnico.DNI));
	//return listaTecnicoDisponible;
}	
	
	
}	

}