package co.com.bucaramanga.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ta_proveedor")
public class Proveedor implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String NOMBRE_SECUENCIA = "Proveedor.codigo";
	
	@Id
	@SequenceGenerator(name = Proveedor.NOMBRE_SECUENCIA, sequenceName = "sq_ta_proveedor", allocationSize=1)
	@GeneratedValue(generator = Proveedor.NOMBRE_SECUENCIA, strategy = GenerationType.SEQUENCE)
	@Column(name="nmproveedor")
	private Long codigo;
	
	private Long nit;
	
	private String razonSocial;
	
	private String direccion;
	
	private String telefono;
	
	private String correo;
	
	private String observacion;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial == null ? "" : razonSocial.toUpperCase();
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion == null ? "" : direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo == null ? "" : correo.toUpperCase();
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getObservacion() {
		return observacion == null ? "" : observacion.toUpperCase();
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}
