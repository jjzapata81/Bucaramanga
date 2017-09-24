package co.com.bucaramanga.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ta_salida")
public class Salida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nmsalida")
	private Long codSalida;

	@Column(name="nmfacturaventa")
	private Long facturaVenta;
	
	private Date feFacturaVenta;

	public Long getCodSalida() {
		return codSalida;
	}

	public void setCodSalida(Long codSalida) {
		this.codSalida = codSalida;
	}

	public Long getFacturaVenta() {
		return facturaVenta;
	}

	public void setFacturaVenta(Long facturaVenta) {
		this.facturaVenta = facturaVenta;
	}

	public Date getFeFacturaVenta() {
		return feFacturaVenta;
	}

	public void setFeFacturaVenta(Date feFacturaVenta) {
		this.feFacturaVenta = feFacturaVenta;
	}
	
}
