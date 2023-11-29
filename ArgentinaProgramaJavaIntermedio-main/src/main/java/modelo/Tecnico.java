package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table (name="Tecnico")
@NoArgsConstructor
@Getter @Setter

	public class Tecnico implements Serializable{
	@Id
	@Column (name="DNI")
	private String DNI;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	@Column (name="telefono")
	private String telefono;
	@Column (name="mail")
	private String mail;
	@ManyToMany
	private List <Servicio> especialidades;
	@Column (name="activo")
	private boolean activo = true;
	@ManyToMany
	private List <TipoDeProblema> tiposDeProblemas;
	@Column (name="medioContacto")
	private String medioContacto;
	
	public Tecnico(String DNI, String nombre, String apellido, String telefono, String mail,
	 String medioContacto) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.medioContacto = medioContacto;
		this.especialidades = new ArrayList<Servicio>();
		this.tiposDeProblemas = new ArrayList<TipoDeProblema>();
	}
	
	public void bajaTecnico() {
		this.activo = false;
	}
	
	public void agregarEspecialidad(Servicio servicio) {
		especialidades.add(servicio);
	}
	
	public void agregarTipoDeProblema(TipoDeProblema tipoDeProblema) {
		tiposDeProblemas.add(tipoDeProblema);
	}
	
	
	
	
}
