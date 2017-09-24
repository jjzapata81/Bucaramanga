package co.com.bucaramanga.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ta_entrada")
public class Entrada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nmentrada")
	private Long codEntrada;
	
	@Column(name="nmproveedor")
	private Long codProveedor;

	@Column(name="nmfacturacompra")
	private Long facturaCompra;
	
	private Date feFacturaCompra;

	public Long getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(Long codEntrada) {
		this.codEntrada = codEntrada;
	}

	public Long getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(Long codProveedor) {
		this.codProveedor = codProveedor;
	}

	public Long getFacturaCompra() {
		return facturaCompra;
	}

	public void setFacturaCompra(Long facturaCompra) {
		this.facturaCompra = facturaCompra;
	}

	public Date getFeFacturaCompra() {
		return feFacturaCompra;
	}

	public void setFeFacturaCompra(Date feFacturaCompra) {
		this.feFacturaCompra = feFacturaCompra;
	}
	
}
