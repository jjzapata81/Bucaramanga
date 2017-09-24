package co.com.bucaramanga.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import co.com.bucaramanga.entities.converter.BooleanConverter;

@Entity
@Table(name="ta_productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String codProducto;
	
	private String nombre;
	
	private String observacion;

	@Column(name="sniva")
	@Convert(converter = BooleanConverter.class)
	private boolean tieneIva;
	
	private Double porcentajeIva;

	@Column(name="snactivo")
	@Convert(converter = BooleanConverter.class)
	private boolean activo;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean isTieneIva() {
		return tieneIva;
	}

	public void setTieneIva(boolean tieneIva) {
		this.tieneIva = tieneIva;
	}

	public Double getPorcentajeIva() {
		return porcentajeIva == null ? 0D : porcentajeIva;
	}

	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@PrePersist
	private void onPersist() {
		activo = true;
	}

}
