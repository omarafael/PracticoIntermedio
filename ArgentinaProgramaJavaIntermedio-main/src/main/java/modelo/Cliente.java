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
@Table (name="Cliente")
@NoArgsConstructor
@Getter @Setter
public class Cliente implements Serializable{
	@Id
	@Column (name="cuitCuil")
	private String cuitCuil;
	
	@Column (name="razonSocial")
	private String razonSocial;
	
	@Column (name="domicilio")
	private String domicilio;
	
	@Column (name="telefono")
	private String telefono;
	
	@Column (name="mail")
	private String mail;
	
	@ManyToMany
	private List <Servicio> serviciosContratados;
	
	@Column (name = "activo")
	private boolean activo = true;
	
	

	
	public Cliente(String cuitCuil, String razonSocial, String domicilio, String telefono, String mail
			, boolean activo) {
	
		this.cuitCuil = cuitCuil;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.activo = activo;
		serviciosContratados = new ArrayList<Servicio>();
	}
	
	
	public void bajaCliente() {
		this.activo = false;
	}
	
	public void agregarServicio(Servicio servicio) {
		serviciosContratados.add(servicio);
	}
	
	public List serviciosContratados() {
		return serviciosContratados;
	}
}
