package modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name="TipoDeProblema")
@NoArgsConstructor
@Getter @Setter
public class TipoDeProblema implements Serializable {

	@Id
	@Column	(name="idTipoDeProblema")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoDeProblema;
	@Column (name="tipoDeProblema")
	private String tipoDeProblema;
	@Column (name="tiempoMaxRes")	
	private int tiempoMaxRes;
	@Column (name="activo")
	private boolean activo=true;
	
	public TipoDeProblema(String tipoDeProblema, int tiempoMaxRes) {
		this.tipoDeProblema = tipoDeProblema;
		this.tiempoMaxRes = tiempoMaxRes;
	
	}
	
	public void bajaTipoDeProblema() {
		this.activo = false;
	}
	
	
}