package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name="ProvisionDeServicio")
@NoArgsConstructor
@Getter @Setter
public class ProvisionDeServicio implements Serializable {
	
	@Id
	@Column	(name="idProvision")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProvision;
    @ManyToOne
	private Servicio servicio;
    @ManyToOne
	private Cliente cliente;
    @Column
	private Boolean pagoMensual;
    @Column
	private LocalDate fechaDeAlta;
	
    public ProvisionDeServicio(Servicio servicio, Cliente cliente, Boolean pagoMensual, LocalDate fechaDeAlta) {
	
		this.servicio = servicio;
		this.cliente = cliente;
		this.pagoMensual = pagoMensual;
		this.fechaDeAlta = fechaDeAlta;
		
	}
    
  
    

}