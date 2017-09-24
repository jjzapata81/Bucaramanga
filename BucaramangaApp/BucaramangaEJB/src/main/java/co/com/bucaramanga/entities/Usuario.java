package co.com.bucaramanga.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.bucaramanga.entities.converter.BooleanConverter;

@Entity
@Table(name="ta_usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String nombre;
	
	private String apellido;

	@Column(name="snactivo")
	@Convert(converter = BooleanConverter.class)
	private boolean activo;

	private String nombreUsuario;
	
	private String pass;
	
	private Date feIngreso;
	
	private Date feBaja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public Date getFeBaja() {
		return feBaja;
	}
	
	public void setFeBaja(Date feBaja) {
		this.feBaja = feBaja;
	}
	
	public Date getFeIngreso() {
		return feIngreso;
	}
	
	public void setFeIngreso(Date feIngreso) {
		this.feIngreso = feIngreso;
	}

	public String getNombreCompleto() {
		return String.format("%s %s", nombre, apellido);
	}
	
}
